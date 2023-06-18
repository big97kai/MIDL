package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.MIDLapp;
import app.SymbolTable;
import app.VariableType;
import bean.type.BaseType;

import java.util.List;

public class AntlrToIntegerType extends MIDLBaseVisitor<BaseType> {
    private List<String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    public AntlrToIntegerType(List<String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable) {

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
    public BaseType visitIntegerTypeToSignedInt(MIDLParser.IntegerTypeToSignedIntContext ctx) {

        AntlrToSignedInt antlrToSignedInt = new AntlrToSignedInt(semanticErrors, indentationTimes, expOneOutPut, symbolTable);
        return antlrToSignedInt.visit(ctx.getChild(0));
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
    public BaseType visitIntegerTypeToUnSignedInt(MIDLParser.IntegerTypeToUnSignedIntContext ctx) {

        AntlrToUnsigndInt antlrToUnsigndInt = new AntlrToUnsigndInt(semanticErrors, indentationTimes, expOneOutPut, symbolTable);
        return antlrToUnsigndInt.visit(ctx.getChild(0));
    }
}
