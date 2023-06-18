package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.SymbolTable;
import bean.expression.CalculateNode;
import bean.expression.Expression;
import bean.expression.ExpressionNode;
import bean.expression.UnaryExpr;

import java.util.List;

public class AntlrToExpressionNode extends MIDLBaseVisitor<ExpressionNode> {

    private List<String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    public AntlrToExpressionNode(List<String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable) {

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
    public ExpressionNode visitOr_expr(MIDLParser.Or_exprContext ctx) {


        expOneOutPut.addOneName("XorNode", indentationTimes);
        indentationTimes++;
        Expression firstNode = this.visit(ctx.getChild(0));
        indentationTimes--;
        ExpressionNode expressionNode = new ExpressionNode(firstNode);
        int nodeSize = ctx.getChildCount();
        for (int i = 1; i < nodeSize; ) {

            expOneOutPut.addOneName("XorNode", indentationTimes);
            String symbol = ctx.getChild(i).getText();
            Expression node = this.visit(ctx.getChild(i + 1));
            CalculateNode calnode = new CalculateNode(symbol, node);
            expressionNode.addNodeIntoNodeList(calnode);
            i += 2;
        }

        return expressionNode;
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
    public ExpressionNode visitXor_expr(MIDLParser.Xor_exprContext ctx) {

        expOneOutPut.addOneName("AndNode", indentationTimes);
        indentationTimes++;
        Expression firstNode = this.visit(ctx.getChild(0));
        indentationTimes--;
        ExpressionNode expressionNode = new ExpressionNode(firstNode);
        int nodeSize = ctx.getChildCount();
        for (int i = 1; i < nodeSize; ) {

            expOneOutPut.addOneName("AndNode", indentationTimes);
            String symbol = ctx.getChild(i).getText();
            Expression node = this.visit(ctx.getChild(i + 1));
            CalculateNode calnode = new CalculateNode(symbol, node);
            expressionNode.addNodeIntoNodeList(calnode);
            i += 2;
        }

        return expressionNode;
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
    public ExpressionNode visitAnd_expr(MIDLParser.And_exprContext ctx) {

        expOneOutPut.addOneName("ShiftNode", indentationTimes);
        indentationTimes++;
        Expression firstNode = this.visit(ctx.getChild(0));
        indentationTimes--;
        ExpressionNode expressionNode = new ExpressionNode(firstNode);
        int nodeSize = ctx.getChildCount();
        for (int i = 1; i < nodeSize; ) {

            expOneOutPut.addOneName("ShiftNode", indentationTimes);
            String symbol = ctx.getChild(i).getText();
            Expression node = this.visit(ctx.getChild(i + 1));
            CalculateNode calnode = new CalculateNode(symbol, node);
            expressionNode.addNodeIntoNodeList(calnode);
            i += 2;
        }

        return expressionNode;
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
    public ExpressionNode visitShift_expr(MIDLParser.Shift_exprContext ctx) {

        expOneOutPut.addOneName("AddNode", indentationTimes);
        indentationTimes++;
        Expression firstNode = this.visit(ctx.getChild(0));
        indentationTimes--;
        ExpressionNode expressionNode = new ExpressionNode(firstNode);
        int nodeSize = ctx.getChildCount();
        for (int i = 1; i < nodeSize; ) {
            expOneOutPut.addOneName("AddNode", indentationTimes);
            String symbol = ctx.getChild(i).getText();
            Expression node = this.visit(ctx.getChild(i + 1));
            CalculateNode calnode = new CalculateNode(symbol, node);
            expressionNode.addNodeIntoNodeList(calnode);
            i += 2;
        }

        return expressionNode;
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
    public ExpressionNode visitAdd_expr(MIDLParser.Add_exprContext ctx) {

        expOneOutPut.addOneName("MultNode", indentationTimes);
        indentationTimes++;
        Expression firstNode = this.visit(ctx.getChild(0));
        indentationTimes--;
        ExpressionNode expressionNode = new ExpressionNode(firstNode);
        int nodeSize = ctx.getChildCount();
        for (int i = 1; i < nodeSize; ) {
            expOneOutPut.addOneName("MultNode", indentationTimes);
            String symbol = ctx.getChild(i).getText();
            Expression node = this.visit(ctx.getChild(i + 1));
            CalculateNode calnode = new CalculateNode(symbol, node);
            expressionNode.addNodeIntoNodeList(calnode);
            i += 2;
        }

        return expressionNode;
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
    public ExpressionNode visitMult_expr(MIDLParser.Mult_exprContext ctx) {

        expOneOutPut.addOneName("UnaryNode", indentationTimes);

        AntlrToUnaryExpr unaryExprVisitor = new AntlrToUnaryExpr(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable);
        UnaryExpr firstNode = unaryExprVisitor.visit(ctx.getChild(0));

        ExpressionNode expressionNode = new ExpressionNode(firstNode);
        int nodeSize = ctx.getChildCount();
        for (int i = 1; i < nodeSize; ) {

            expOneOutPut.addOneName("UnaryNode", indentationTimes);
            String symbol = ctx.getChild(i).getText();
            Expression node = unaryExprVisitor.visit(ctx.getChild(i + 1));
            CalculateNode calnode = new CalculateNode(symbol, node);
            expressionNode.addNodeIntoNodeList(calnode);
            i += 2;
        }

        return expressionNode;
    }
}
