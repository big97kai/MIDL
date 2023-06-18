package bean.literal;

import java.math.BigDecimal;

public class FloatingPoint extends Literal {

    private BigDecimal value;

    public FloatingPoint(BigDecimal value) {

        this.value = value;
    }

    @Override
    public java.lang.String toString() {
        return null;
    }
}
