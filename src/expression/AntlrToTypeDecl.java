package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.Scope;
import app.ScopeType;
import app.SymbolTable;
import bean.Genration.Struct;
import bean.Genration.Structs;
import bean.struct.SimpleStruct;
import bean.struct.TypeDecl;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class AntlrToTypeDecl extends MIDLBaseVisitor<TypeDecl> {

    private List<java.lang.String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    private Structs structs;
    public AntlrToTypeDecl(List<java.lang.String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable, Structs structs) {

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
    public TypeDecl visitTypeDeclToStructType(MIDLParser.TypeDeclToStructTypeContext ctx) {

        expOneOutPut.addOneName("Struct", indentationTimes);
        AntlrToStructType structTypeVisitor = new AntlrToStructType(semanticErrors, indentationTimes, expOneOutPut, symbolTable, structs);
        return structTypeVisitor.visit(ctx.getChild(0));
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
    public TypeDecl visitTypeDeclToStructId(MIDLParser.TypeDeclToStructIdContext ctx) {


        Token idToken = ctx.ID().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1;
        String id = ctx.getChild(1).getText();

        String structName = ctx.ID().getText();
        Scope currentScope = symbolTable.currentScope();
        Scope allfather = symbolTable.getFather();
        while(currentScope != allfather){

            structName = currentScope.getName() + "_" + structName;
            currentScope = currentScope.getFatherScope();
        }

        Struct struct = new Struct(structName);
        structs.addStruct(struct);

        if(symbolTable.testScopeName(symbolTable.currentScope(), id, ScopeType.STRUCT)){

            semanticErrors.add("Error: variable " + id + " double defined (" + line + ", " + column + ")");
        }
        symbolTable.pushScope(id, ScopeType.STRUCT);
        SimpleStruct simpleStruct = new SimpleStruct(id);
        expOneOutPut.addOneName("SimpleStruct", indentationTimes);
        symbolTable.popScope();
        return simpleStruct;
    }
}
