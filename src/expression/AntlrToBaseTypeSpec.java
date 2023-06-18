package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.MIDLapp;
import app.SymbolTable;
import app.VariableType;
import bean.type.BaseType;

import java.util.List;

public class AntlrToBaseTypeSpec extends MIDLBaseVisitor<BaseType> {

    private List<String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    public AntlrToBaseTypeSpec(List<String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable) {

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
    public BaseType visitBaseTypeSpecToFloatingPtType(MIDLParser.BaseTypeSpecToFloatingPtTypeContext ctx) {

        AntlrToFP antlrToFP = new AntlrToFP(semanticErrors, indentationTimes, expOneOutPut, symbolTable);
        return antlrToFP.visit(ctx.getChild(0));
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
    public BaseType visitBaseTypeSpecToIntegerType(MIDLParser.BaseTypeSpecToIntegerTypeContext ctx) {

        AntlrToIntegerType antlrToIntegerType = new AntlrToIntegerType(semanticErrors, indentationTimes, expOneOutPut, symbolTable);
        return antlrToIntegerType.visit(ctx.getChild(0));
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
    public BaseType visitBaseTypeSpecToChar(MIDLParser.BaseTypeSpecToCharContext ctx) {

        MIDLapp.CURRENTTYPE = VariableType.BASETYPE;
        MIDLapp.CURRENTTYPENAME = "Char";
        expOneOutPut.addOneName("Char", indentationTimes);
        BaseType baseType = new BaseType(ctx.getChild(0).getText());

        return baseType;
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
    public BaseType visitBaseTypeSpecToString(MIDLParser.BaseTypeSpecToStringContext ctx) {

        expOneOutPut.addOneName("String", indentationTimes);
        MIDLapp.CURRENTTYPE = VariableType.BASETYPE;
        MIDLapp.CURRENTTYPENAME = "String";
        BaseType baseType = new BaseType(ctx.getChild(0).getText());

        return baseType;
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
    public BaseType visitBaseTypeSpecToBoolean(MIDLParser.BaseTypeSpecToBooleanContext ctx) {
        MIDLapp.CURRENTTYPE = VariableType.BASETYPE;
        MIDLapp.CURRENTTYPENAME = "Boolean";
        expOneOutPut.addOneName("Boolean", indentationTimes);
        BaseType baseType = new BaseType(ctx.getChild(0).getText());

        return baseType;
    }
}
