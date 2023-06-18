package app;

import java.util.ArrayList;
import java.util.List;

public class ExpOneOutPut {

    private List<Integer> indentationList;

    private List<String> nameList;

    public List<String> getNameList() {
        return nameList;
    }

    public ExpOneOutPut() {
        this.indentationList = new ArrayList<>();
        this.nameList = new ArrayList<>();
    }

    public void addOneName(String name, Integer indentation){

        this.addIndentation(indentation);
        this.addNameList(name);
    }

    private void addNameList(String name){

        nameList.add(name);
    }

    private void addIndentation(Integer indentation){

        indentationList.add(indentation);
    }

    public List<Integer> getIndentationList() {
        return indentationList;
    }

}
