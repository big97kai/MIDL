package bean.expression;

import bean.literal.Literal;

public class UnaryExpr extends Expression {

    private java.lang.String symbol;

    private Literal literal;

    public UnaryExpr(java.lang.String symbol, Literal literal) {

        this.symbol = symbol;
        this.literal = literal;
    }

    public UnaryExpr(Literal literal){

        this.literal = literal;
    }

    @Override
    public java.lang.String toString() {
        return null;
    }
}
