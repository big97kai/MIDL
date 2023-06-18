package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.ScopeType;
import app.SymbolTable;
import bean.Genration.Structs;
import bean.struct.Definition;
import bean.struct.Module;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class AntlrToModule extends MIDLBaseVisitor<Module> {
    private List<java.lang.String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    private Structs structs;
    public AntlrToModule(List<java.lang.String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable, Structs structs) {

        this.expOneOutPut = expOneOutPut;
        this.semanticErrors = semanticErrors;
        this.indentationTimes = indentationTimes;
        this.symbolTable = symbolTable;
        this.structs = structs;
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
    public Module visitModule(MIDLParser.ModuleContext ctx) {

        String id = ctx.getChild(1).getText();

        Module module = new Module(id);
        expOneOutPut.addOneName("ID", indentationTimes);

        Token idToken = ctx.ID().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1;
        if(symbolTable.testScopeName(symbolTable.currentScope(), id, ScopeType.MODULE)){

            semanticErrors.add("Error: variable " + id + " double defined (" + line + ", " + column + ")");
        }
        symbolTable.pushScope(id, ScopeType.MODULE);
        AntlrToDefinition definitionVisitor = new AntlrToDefinition(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable, structs);
        int size = ctx.getChildCount() - 1;
        for (int i = 3; i < size; i++) {

            expOneOutPut.addOneName("Definition", indentationTimes);
            Definition definition = definitionVisitor.visit(ctx.getChild(i));
            module.addDefinition(definition);
        }

        symbolTable.popScope();
        return module;
    }
}
