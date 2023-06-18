package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.MIDLapp;
import app.SymbolTable;
import app.VariableType;
import bean.type.BaseType;

import java.util.List;

public class AntlrToSignedInt extends MIDLBaseVisitor<BaseType> {

    private List<String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    public AntlrToSignedInt(List<java.lang.String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable) {

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
    public BaseType visitSignedIntToInt16(MIDLParser.SignedIntToInt16Context ctx) {
        expOneOutPut.addOneName("Int16", indentationTimes);
        MIDLapp.CURRENTTYPE = VariableType.BASETYPE;
        MIDLapp.CURRENTTYPENAME = "Int16";
        return new BaseType("Int16");
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
    public BaseType visitSignedIntToInt32(MIDLParser.SignedIntToInt32Context ctx) {
        expOneOutPut.addOneName("Int32", indentationTimes);
        MIDLapp.CURRENTTYPE = VariableType.BASETYPE;
        MIDLapp.CURRENTTYPENAME = "Int32";
        return new BaseType("Int32");
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
    public BaseType visitSignedIntToInt64(MIDLParser.SignedIntToInt64Context ctx) {
        expOneOutPut.addOneName("Int64", indentationTimes);
        MIDLapp.CURRENTTYPE = VariableType.BASETYPE;
        MIDLapp.CURRENTTYPENAME = "Int64";
        return new BaseType("Int64");
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
    public BaseType visitSignedIntToIn8(MIDLParser.SignedIntToIn8Context ctx) {
        expOneOutPut.addOneName("Int8", indentationTimes);
        MIDLapp.CURRENTTYPE = VariableType.BASETYPE;
        MIDLapp.CURRENTTYPENAME = "Int8";
        return new BaseType("Int8");
    }
}
