package bean.literal;

import java.math.BigInteger;

public class Integer extends Literal {

    private BigInteger value;

    public Integer(BigInteger value) {

        this.value = value;
    }

    @Override
    public java.lang.String toString() {
        return null;
    }
}
