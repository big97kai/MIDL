package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.MIDLapp;
import app.SymbolTable;
import app.VariableType;
import bean.type.BaseType;

import java.util.List;

public class AntlrToUnsigndInt extends MIDLBaseVisitor<BaseType> {

    private List<String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    public AntlrToUnsigndInt(List<java.lang.String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable) {

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
    public BaseType visitUnSignedIntToUint32(MIDLParser.UnSignedIntToUint32Context ctx) {
        expOneOutPut.addOneName("Uint32", indentationTimes);
        MIDLapp.CURRENTTYPE = VariableType.BASETYPE;
        MIDLapp.CURRENTTYPENAME = "Uint32";
        return new BaseType("Uint32");
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
    public BaseType visitUnSignedIntToUint16(MIDLParser.UnSignedIntToUint16Context ctx) {
        expOneOutPut.addOneName("Uint16", indentationTimes);
        MIDLapp.CURRENTTYPE = VariableType.BASETYPE;
        MIDLapp.CURRENTTYPENAME = "Uint16";
        return new BaseType("Uint16");
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
    public BaseType visitUnSignedIntToUint8(MIDLParser.UnSignedIntToUint8Context ctx) {

        expOneOutPut.addOneName("Uint8", indentationTimes);
        MIDLapp.CURRENTTYPE = VariableType.BASETYPE;
        MIDLapp.CURRENTTYPENAME = "Uint8";
        return new BaseType("Uint8");
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
    public BaseType visitUnSignedIntToUint64(MIDLParser.UnSignedIntToUint64Context ctx) {

        expOneOutPut.addOneName("Uint64", indentationTimes);
        MIDLapp.CURRENTTYPE = VariableType.BASETYPE;
        MIDLapp.CURRENTTYPENAME = "Uint64";
        return new BaseType("Uint64");
    }
}
