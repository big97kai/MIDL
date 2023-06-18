package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.MIDLapp;
import app.SymbolTable;
import app.VariableType;
import bean.type.BaseType;

import java.util.List;

public class AntlrToFP extends MIDLBaseVisitor<BaseType> {

    private List<String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    public AntlrToFP(List<String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable) {

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
    public BaseType visitFloatToFloat(MIDLParser.FloatToFloatContext ctx) {

        expOneOutPut.addOneName("Float", indentationTimes);
        MIDLapp.CURRENTTYPE = VariableType.BASETYPE;
        MIDLapp.CURRENTTYPENAME = "Float";
        return new BaseType("Float");
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
    public BaseType visitFloatToDouble(MIDLParser.FloatToDoubleContext ctx) {

        expOneOutPut.addOneName("Double", indentationTimes);
        MIDLapp.CURRENTTYPE = VariableType.BASETYPE;
        MIDLapp.CURRENTTYPENAME = "Double";
        return new BaseType("Double");
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
    public BaseType visitFloatToLongDouble(MIDLParser.FloatToLongDoubleContext ctx) {

        expOneOutPut.addOneName("LongDouble", indentationTimes);
        MIDLapp.CURRENTTYPE = VariableType.BASETYPE;
        MIDLapp.CURRENTTYPENAME = "LongDouble";
        return new BaseType("LongDouble");
    }
}
