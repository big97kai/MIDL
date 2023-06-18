package bean.Genration;

import java.util.ArrayList;
import java.util.List;

public class Structs {

    private List<Struct> structList;

    public Structs(){

        this.structList = new ArrayList<>();
    }

    public void addStruct(Struct e){

        structList.add(e);
    }

    public List<Struct> getStructList() {
        return structList;
    }
}
