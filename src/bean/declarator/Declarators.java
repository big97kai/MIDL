package bean.declarator;

import bean.Experiment2;

import java.util.List;

public class Declarators extends Experiment2 {

    private Declarator singleDeclarator;

    private List<Declarator> declaratorList;

    public Declarators(Declarator singleDeclarator) {

        this.singleDeclarator = singleDeclarator;
    }

    public void addDeclarator(Declarator e) {

        declaratorList.add(e);
    }

    @Override
    public String toString() {
        return null;
    }
}
