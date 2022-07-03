import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideTest implements TestsInterface {
    Complex num;
    Complex num2;

    @Override
    @BeforeEach
    public void setup() {
        this.num = new ComplexImp(12.33d, -78.5d);
        this.num2 = new ComplexImp(0d, 556.40d);
    }

    @Test
    void divideTest() {
        Complex res = num.divide(num2);
        assertEquals(-0.14108554996405465d, res.getRealPart());
        assertEquals(-0.022160316319194826d, res.getComplexPart());
    }
}
