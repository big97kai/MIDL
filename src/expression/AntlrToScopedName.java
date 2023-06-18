package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.*;
import bean.type.ScopedName;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;

import java.util.List;

import static app.MIDLapp.CURRENTTYPE;
import static app.MIDLapp.CURRENTTYPENAME;

public class AntlrToScopedName extends MIDLBaseVisitor<ScopedName> {
    private List<java.lang.String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    public AntlrToScopedName(List<java.lang.String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable) {

        this.expOneOutPut = expOneOutPut;
        this.semanticErrors = semanticErrors;
        this.indentationTimes = indentationTimes;
        this.symbolTable = symbolTable;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public ScopedName visitScoped_name(MIDLParser.Scoped_nameContext ctx) {

        CURRENTTYPE = VariableType.SCOPE;
        CURRENTTYPENAME = "";
        String id;
        ScopedName scopedName = null;

        Scope fatherScope = symbolTable.getFather();
        int currentIndex = 0;
        int idIndex = 0;

        if (ctx.getChild(0).getText().equals("::")) {

            currentIndex++;
        }

        expOneOutPut.addOneName("ID", indentationTimes);

        id = ctx.getChild(currentIndex).getText();

        if(fatherScope.getChild(id) != null){

            idIndex++;
            fatherScope = fatherScope.getChild(id);
            CURRENTTYPENAME += id;
            scopedName = new ScopedName(id);
            int size = ctx.getChildCount();
            for (int i = currentIndex + 2; i < size; ) {

                id = ctx.getChild(i).getText();

                if(fatherScope.getChild(id) != null){

                    idIndex++;
                    fatherScope = fatherScope.getChild(id);
                    expOneOutPut.addOneName("ID", indentationTimes);

                    CURRENTTYPENAME += "::";
                    CURRENTTYPENAME += id;

                    scopedName.addId(id);
                    i += 2;
                }else{

                    Token idToken = ctx.ID(idIndex).getSymbol();
                    int line = idToken.getLine();
                    int column = idToken.getCharPositionInLine() + 1;
                    semanticErrors.add("Error: couldn't find scope name " + id + ".("+ line + ", " + column + ")");
                    i+=2;
                }
            }
        }else {

            Token idToken = ctx.ID(idIndex).getSymbol();
            int line = idToken.getLine();
            int column = idToken.getCharPositionInLine() + 1;
            semanticErrors.add("Error: couldn't find scope name " + id + ".("+ line + ", " + column + ")");
        }

        return scopedName;
    }
}
