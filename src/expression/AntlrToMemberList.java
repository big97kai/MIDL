package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.SymbolTable;
import bean.Genration.Struct;
import bean.Genration.Structs;
import bean.declarator.Declarators;
import bean.struct.Member;
import bean.struct.MemberList;
import bean.type.TypeSpec;

import java.util.List;

public class AntlrToMemberList extends MIDLBaseVisitor<MemberList> {
    private List<java.lang.String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    private Structs structs;
    private Struct struct;
    public AntlrToMemberList(List<java.lang.String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable, Structs structs, Struct struct) {

        this.expOneOutPut = expOneOutPut;
        this.semanticErrors = semanticErrors;
        this.indentationTimes = indentationTimes;
        this.symbolTable = symbolTable;
        this.structs = structs;
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
    public MemberList visitMember_list(MIDLParser.Member_listContext ctx) {

        MemberList memberList = new MemberList();
        int size = ctx.getChildCount();

        AntlrToTypeSpec typeSpecVisitor = new AntlrToTypeSpec(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable, structs);
        AntlrToDeclarators declaratorsVisitor = new AntlrToDeclarators(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable, struct);

        for (int i = 0; i < size; ) {

            expOneOutPut.addOneName("TypeSpecific", indentationTimes);
            TypeSpec typeSpec = typeSpecVisitor.visit(ctx.getChild(i));
            expOneOutPut.addOneName("Declarators", indentationTimes);
            Declarators declarators = declaratorsVisitor.visit(ctx.getChild(i + 1));
            Member member = new Member(typeSpec, declarators);
            memberList.addMember(member);
            i += 3;
        }

        return memberList;
    }
}
