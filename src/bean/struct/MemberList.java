package bean.struct;

import bean.Experiment2;

import java.util.ArrayList;
import java.util.List;

public class MemberList extends Experiment2 {

    private List<Member> memberList;

    public MemberList() {

        memberList = new ArrayList<>();
    }

    public void addMember(Member e) {

        memberList.add(e);
    }

    @Override
    public String toString() {
        return null;
    }
}
