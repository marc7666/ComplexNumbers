import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivideByZeroTest implements TestsInterface {
    Complex num;
    Complex num2;

    @Override
    @BeforeEach
    public void setup() {
        this.num2 = new ComplexImp(0d, 0d);
        this.num = new ComplexImp(12.22d, 564.2);
    }

    @Test
    void divideByZeroTest() {
        assertThrows(ArithmeticException.class,
                () -> num.divide(num2));
    }
}
