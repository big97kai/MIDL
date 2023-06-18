package bean.Genration;

public class Variable {

    public boolean getIstring() {
        return istring;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public boolean getIsimple() {
        return isimple;
    }

    public void setSimple(boolean simple) {
        isimple = simple;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    private boolean isimple = false;

    private boolean istring;
    private String type = "";
    private String id = "";
    private String value = "";

    public Variable(String id, String type){

        this.id = id;
        this.type = type;
    }

    public void setString(boolean string) {
        istring = string;
    }

    public void setIsSimple(boolean isSimple) {
        this.isimple = isSimple;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString(){

        return this.id + " " +  this.type + " " + this.isimple;
    }
}
