package bean.expression;

import java.util.ArrayList;
import java.util.List;

public class ExpressionNode extends Expression {


    private Expression node;
    private List<CalculateNode> nodeList;

    public ExpressionNode(Expression node) {

        this.node = node;
        nodeList = new ArrayList<>();
    }

    public void addNodeIntoNodeList(CalculateNode node) {

        nodeList.add(node);
    }

    @Override
    public java.lang.String toString() {
        return null;
    }
}
