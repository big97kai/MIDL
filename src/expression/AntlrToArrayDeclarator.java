package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.*;
import bean.Genration.Struct;
import bean.Genration.Variable;
import bean.declarator.ArrayDeclarator;
import org.antlr.v4.runtime.Token;

import java.util.List;

import static app.MIDLapp.CURRENTTYPE;
import static app.VariableType.BASETYPE;

public class AntlrToArrayDeclarator extends MIDLBaseVisitor<ArrayDeclarator> {

    private List<String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;

    private Struct struct;
    public AntlrToArrayDeclarator(List<String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable, Struct struct) {

        this.expOneOutPut = expOneOutPut;
        this.semanticErrors = semanticErrors;
        this.indentationTimes = indentationTimes;
        this.symbolTable = symbolTable;
        this.struct = struct;
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
    public ArrayDeclarator visitArray_declarator(MIDLParser.Array_declaratorContext ctx) {

        expOneOutPut.addOneName("ID", indentationTimes);
        expOneOutPut.addOneName("OrNode", indentationTimes);

        // check for variable double defined
        String id = ctx.getChild(0).getText();
        Token idToken = ctx.ID().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1;

        Variable variable = new Variable(id + "[" + ctx.getChild(2).getText() + "]", MIDLapp.CURRENTTYPENAME);
        if (ctx.getChildCount() > 4) {

            variable.setIsSimple(false);
            variable.setValue(ctx.getChild(5).getText());
        }else{

            variable.setIsSimple(true);
        }
        if(MIDLapp.CURRENTTYPENAME.equals("String")){

            variable.setString(true);
        }else{

            variable.setString(false);
        }
        struct.addViriable(variable);

        if(CURRENTTYPE == BASETYPE){

            Symbol symbol = new Symbol(id, MIDLapp.CURRENTTYPENAME);

            if(symbolTable.currentScope().getSymbolMap().containsKey(id)){

                semanticErrors.add("Error: variable " + id + " double defined (" + line + ", " + column + ")");
            }else {

                symbolTable.currentScope().define(symbol);
            }
        }

        AntlrToExpressionNode expressionNodeVisitor = new AntlrToExpressionNode(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable);
        AntlrToExpList expListVisitor = new AntlrToExpList(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable);
        ArrayDeclarator arrayDeclarator = new ArrayDeclarator(ctx.getChild(0).getText(), expressionNodeVisitor.visit(ctx.getChild(2)));

        if (ctx.getChildCount() > 4) {

            expOneOutPut.addOneName("ExpList", indentationTimes);
            arrayDeclarator.setExpList(expListVisitor.visit(ctx.getChild(5)));
        }

        return arrayDeclarator;
    }
}
