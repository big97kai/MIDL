package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.SymbolTable;
import bean.Genration.Structs;
import bean.struct.Definition;

import java.util.List;

public class AntlrToDefinition extends MIDLBaseVisitor<Definition> {
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    private List<String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;

    private Structs structs;
    public AntlrToDefinition(List<String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable, Structs structs) {

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
    public Definition visitDefinitionToTypeDecl(MIDLParser.DefinitionToTypeDeclContext ctx) {

        expOneOutPut.addOneName("TypeDecl", indentationTimes);
        AntlrToTypeDecl typeDeclVisitor = new AntlrToTypeDecl(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable, structs);
        return typeDeclVisitor.visit(ctx.getChild(0));
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
    public Definition visitDefinitionToModule(MIDLParser.DefinitionToModuleContext ctx) {

        expOneOutPut.addOneName("Module", indentationTimes);
        AntlrToModule moduleVisitor = new AntlrToModule(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable, structs);
        return moduleVisitor.visit(ctx.getChild(0));
    }
}
