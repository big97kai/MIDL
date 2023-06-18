package bean.struct;


import bean.type.TypeSpec;

public class StructType extends TypeSpec {

    private java.lang.String id;

    private MemberList memberList;

    public StructType(java.lang.String id) {

        this.id = id;
    }

    public void addMemberList(MemberList e) {

        this.memberList = e;
    }

    @Override
    public java.lang.String toString() {
        return null;
    }
}
