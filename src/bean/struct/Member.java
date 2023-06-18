package bean.struct;

import bean.Experiment2;
import bean.declarator.Declarators;
import bean.type.TypeSpec;

public class Member extends Experiment2 {

    private TypeSpec typeSpec;

    private Declarators declarators;

    public Member(TypeSpec typeSpec, Declarators declarators) {

        this.typeSpec = typeSpec;
        this.declarators = declarators;
    }

    @Override
    public String toString() {
        return null;
    }
}
