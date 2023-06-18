package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.SymbolTable;
import bean.expression.UnaryExpr;
import bean.literal.Literal;

import java.util.List;

public class AntlrToUnaryExpr extends MIDLBaseVisitor<UnaryExpr> {

    private List<java.lang.String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    public AntlrToUnaryExpr(List<java.lang.String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable) {

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
    public UnaryExpr visitUnary_expr(MIDLParser.Unary_exprContext ctx) {

        expOneOutPut.addOneName("Literal", indentationTimes);
        UnaryExpr unaryExpr;
        AntlrToLiteral literalVisitor = new AntlrToLiteral(semanticErrors, indentationTimes + 1, expOneOutPut, symbolTable);

        if(ctx.getChildCount() == 1){
            Literal literal = literalVisitor.visit(ctx.getChild(0));
            unaryExpr = new UnaryExpr(literal);
        }else{

            String symbol = ctx.getChild(0).getText();
            Literal literal = literalVisitor.visit(ctx.getChild(1));
            unaryExpr = new UnaryExpr(symbol, literal);
        }
        return unaryExpr;
    }
}
