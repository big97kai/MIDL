package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.SymbolTable;
import bean.Genration.Struct;
import bean.declarator.Declarator;
import bean.declarator.Declarators;

import java.util.List;

public class AntlrToDeclarators extends MIDLBaseVisitor<Declarators> {

    private List<String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    private Struct struct;
    public AntlrToDeclarators(List<String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable, Struct struct) {

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
    public Declarators visitDeclarators(MIDLParser.DeclaratorsContext ctx) {

        expOneOutPut.addOneName("Declarator", indentationTimes);
        AntlrToDeclarator declaratorVisitor = new AntlrToDeclarator(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable, struct);
        Declarator declarator = declaratorVisitor.visit(ctx.getChild(0));
        Declarators declarators = new Declarators(declarator);


        int size = ctx.getChildCount();
        for (int i = 1; i < size; i++) {

            expOneOutPut.addOneName("Declarator", indentationTimes);
            Declarator tempDeclarator = declaratorVisitor.visit(ctx.getChild(i + 1));
            declarators.addDeclarator(tempDeclarator);
        }

        return declarators;
    }
}
