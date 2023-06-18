package bean.Genration;

import java.util.ArrayList;
import java.util.List;

public class Struct {
    public String getName() {
        return name;
    }

    public List<Variable> getVariableList() {
        return variableList;
    }

    private String name;
    private List<Variable> variableList;

    public Struct(String name){

        this.name = name;
        variableList = new ArrayList<>();
    }

    public void addViriable(Variable e){

        this.variableList.add(e);
    }
}
