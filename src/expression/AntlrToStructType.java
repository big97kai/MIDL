package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.Scope;
import app.ScopeType;
import app.SymbolTable;
import bean.Genration.Struct;
import bean.Genration.Structs;
import bean.struct.MemberList;
import bean.struct.StructType;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class AntlrToStructType extends MIDLBaseVisitor<StructType> {
    private List<java.lang.String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    private Structs structs;
    public AntlrToStructType(List<java.lang.String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable, Structs structs) {

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
    public StructType visitStruct_type(MIDLParser.Struct_typeContext ctx) {
        String id = ctx.getChild(1).getText();
        StructType structType = new StructType(id);

        expOneOutPut.addOneName("ID", indentationTimes);
        expOneOutPut.addOneName("MemberList", indentationTimes);

        String structName = id;
        Scope currentScope = symbolTable.currentScope();

        Scope allfather = symbolTable.getFather();

        while(currentScope != allfather){

            structName = currentScope.getName() + "_" + structName;
            currentScope = currentScope.getFatherScope();
        }


        Struct struct = new Struct(structName);
        structs.addStruct(struct);

        Token idToken = ctx.ID().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1;

        if(symbolTable.testScopeName(symbolTable.currentScope(), id, ScopeType.STRUCT)){

            semanticErrors.add("Error: struct " + id + " double defined (" + line + ", " + column + ")");
        }
        symbolTable.pushScope(id, ScopeType.STRUCT);
        AntlrToMemberList memberListVisitor = new AntlrToMemberList(semanticErrors, indentationTimes + 1, expOneOutPut, symbolTable, structs, struct);
        MemberList memberList = memberListVisitor.visit(ctx.getChild(3));

        structType.addMemberList(memberList);
        symbolTable.popScope();
        return structType;
    }
}
