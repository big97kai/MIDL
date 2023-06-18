package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.SymbolTable;
import bean.expression.ExpList;
import bean.expression.Expression;
import bean.expression.ExpressionNode;

import java.util.List;

public class AntlrToExpList extends MIDLBaseVisitor<ExpList> {

    private List<String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    public AntlrToExpList(List<String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable) {

        this.expOneOutPut = expOneOutPut;
        this.semanticErrors = semanticErrors;
        this.indentationTimes = indentationTimes;
        this.symbolTable = symbolTable;
    }

    @Override
    public ExpList visitExp_list(MIDLParser.Exp_listContext ctx) {

        expOneOutPut.addOneName("ExpList", indentationTimes);

        AntlrToExpressionNode expressionNodeVisitor = new AntlrToExpressionNode(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable);
        ExpressionNode firstNode = expressionNodeVisitor.visit(ctx.getChild(1));

        ExpList expList = new ExpList(firstNode);
        int nodeSize = ctx.getChildCount();

        if (ctx.getChildCount() > 3) {

            for (int i = 2; i < nodeSize-1; ) {

                ExpressionNode node = expressionNodeVisitor.visit(ctx.getChild(i + 1));
                expList.addNodeIntoNodeList(node);
                i += 2;
            }
        }

        return expList;

    }
}
