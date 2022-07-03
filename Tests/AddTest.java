import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTest implements TestsInterface {
    Complex num;
    Complex num2;

    @Override
    @BeforeEach
    public void setup() {
        this.num = new ComplexImp(12.33d, -78.5d);
        this.num2 = new ComplexImp(0d, 556.40d);
    }

    @Test
    void addTest() {
        Complex res = num.add(num2);
        assertEquals(12.33d, res.getRealPart());
        assertEquals(477.9d, res.getComplexPart());
    }
}
