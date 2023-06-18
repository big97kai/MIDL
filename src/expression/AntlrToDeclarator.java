package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.SymbolTable;
import bean.Genration.Struct;
import bean.declarator.Declarator;

import java.util.List;

public class AntlrToDeclarator extends MIDLBaseVisitor<Declarator> {
    private List<String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    private Struct struct;
    public AntlrToDeclarator(List<String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable, Struct struct) {

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
    public Declarator visitDeclaratorToSimpleDeclarator(MIDLParser.DeclaratorToSimpleDeclaratorContext ctx) {

        expOneOutPut.addOneName("SimpleDeclarator", indentationTimes);

        AntlrToSimpleDeclarator simpleDeclaratorVisitor = new AntlrToSimpleDeclarator(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable, struct);
        return simpleDeclaratorVisitor.visit(ctx.getChild(0));
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
    public Declarator visitDeclaratorToArrayDeclarator(MIDLParser.DeclaratorToArrayDeclaratorContext ctx) {

        expOneOutPut.addOneName("SimpleDeclarator", indentationTimes);

        AntlrToArrayDeclarator arrayDeclaratorVisitor = new AntlrToArrayDeclarator(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable, struct);

        return arrayDeclaratorVisitor.visit(ctx.getChild(0));
    }
}
