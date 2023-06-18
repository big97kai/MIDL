package bean.expression;

import bean.Experiment2;

import java.util.ArrayList;
import java.util.List;

public class ExpList extends Experiment2 {


    private Expression node;
    private List<Expression> nodeList;

    public ExpList(Expression node) {

        this.node = node;
        nodeList = new ArrayList<Expression>();
    }

    public void addNodeIntoNodeList(Expression node) {

        nodeList.add(node);
    }

    @Override
    public java.lang.String toString() {
        return null;
    }


}
