package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.SymbolTable;
import app.VariableType;
import bean.Genration.Structs;
import bean.type.TypeSpec;

import java.util.List;

import static app.MIDLapp.CURRENTTYPE;

public class AntlrToTypeSpec extends MIDLBaseVisitor<TypeSpec> {
    private List<java.lang.String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;

    private Structs structs;
    public AntlrToTypeSpec(List<java.lang.String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable, Structs structs) {

        this.expOneOutPut = expOneOutPut;
        this.semanticErrors = semanticErrors;
        this.indentationTimes = indentationTimes;
        this.symbolTable = symbolTable;
        this.structs= structs;
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
    public TypeSpec visitTypeSpecToScopedName(MIDLParser.TypeSpecToScopedNameContext ctx) {

        expOneOutPut.addOneName("ScopedName", indentationTimes);
        AntlrToScopedName scopedNameVisitor = new AntlrToScopedName(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable);
        return scopedNameVisitor.visit(ctx.getChild(0));
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
    public TypeSpec visitTypeSpecToBaseTypeSpec(MIDLParser.TypeSpecToBaseTypeSpecContext ctx) {

        expOneOutPut.addOneName("BaseType", indentationTimes);
        AntlrToBaseTypeSpec baseTypeSpecVisitor = new AntlrToBaseTypeSpec(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable);
        return baseTypeSpecVisitor.visit(ctx.getChild(0));
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
    public TypeSpec visitTypeSpecToStructType(MIDLParser.TypeSpecToStructTypeContext ctx) {

        CURRENTTYPE = VariableType.STRUCT;
        expOneOutPut.addOneName("Struct", indentationTimes);
        AntlrToStructType structTypeVisitor = new AntlrToStructType(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable, structs);
        return structTypeVisitor.visit(ctx.getChild(0));

    }
}
