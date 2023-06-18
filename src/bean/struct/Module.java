package bean.struct;

import java.util.ArrayList;
import java.util.List;

public class Module extends Definition {

    private java.lang.String id;
    private List<Definition> definitions;

    public Module(java.lang.String id) {

        this.id = id;
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
