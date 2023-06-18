package bean.expression;

public class CalculateNode {

    private java.lang.String symbol;
    private Expression expression;

    public CalculateNode(java.lang.String symbol, Expression expression) {

        this.symbol = symbol;
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public java.lang.String getSymbol() {
        return symbol;
    }

    public void setSymbol(java.lang.String symbol) {
        this.symbol = symbol;
    }
}
