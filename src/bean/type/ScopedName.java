package bean.type;

import java.util.ArrayList;
import java.util.List;

public class ScopedName extends TypeSpec {

    private String id;

    private List<String> idList = new ArrayList<>();

    public ScopedName(String id) {

        this.id = id;
    }

    public void addId(String id) {

        idList.add(id);
    }

    @Override
    public String toString() {
        return null;
    }

}
