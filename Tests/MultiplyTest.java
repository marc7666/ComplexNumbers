import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyTest implements TestsInterface {
    Complex num;
    Complex num2;

    @Override
    @BeforeEach
    public void setup() {
        this.num = new ComplexImp(12.33d, -78.5d);
        this.num2 = new ComplexImp(0d, 556.40d);
    }

    @Test
    void multiplyTest() {
        Complex res = num.multiply(num2);
        assertEquals(43677.4d, res.getRealPart());
        assertEquals(6860.411999999999d, res.getComplexPart());
    }
}
