package bean.struct;

import bean.Experiment2;

import java.util.ArrayList;
import java.util.List;

public class Specification extends Experiment2 {

    private List<Definition> definitions;

    public Specification() {

        this.definitions = new ArrayList<>();
    }

    public void addDefinition(Definition e) {

        definitions.add(e);
    }

    @Override
    public java.lang.String toString() {
        return null;
    }
}
