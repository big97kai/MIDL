package bean.declarator;

import bean.expression.Expression;

public class SimpleDeclarator extends Declarator {

    private String id;

    private Expression expression;

    public SimpleDeclarator(String id) {

        this.id = id;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return null;
    }
}
