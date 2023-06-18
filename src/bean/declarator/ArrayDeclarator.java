package bean.declarator;

import bean.expression.ExpList;
import bean.expression.Expression;

public class ArrayDeclarator extends Declarator {

    private String id;

    private Expression expression;

    private ExpList expList;

    public ArrayDeclarator(String id, Expression expression) {

        this.id = id;
        this.expression = expression;
    }

    public void setExpList(ExpList expList) {
        this.expList = expList;
    }

    @Override
    public String toString() {
        return null;
    }
}
