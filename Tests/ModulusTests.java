import Exceptions.ComponentDoesNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModulusTests implements TestsInterface {
    Complex num;
    Complex num2;
    Complex num3;
    Complex num4;
    Complex num5;
    Complex num6;

    @Override
    @BeforeEach
    public void setup() {
        this.num = new ComplexImp(0d, -78.5d);
        this.num2 = new ComplexImp(0d, 556.40d);
        this.num3 = new ComplexImp(0d, 0d);
        this.num4 = new ComplexImp(56.22d, -78.91d);
        this.num5 = new ComplexImp(-23d, 5d);
        this.num6 = new ComplexImp(-23d, -5d);
    }

    @Test
    void TestComplexPartGreaterThanZero() throws ComponentDoesNotExistException {
        num2.setModulus();
        assertEquals(Math.PI / 2, num2.getModulus());
    }

    @Test
    void TestComplexPartLessThanZero() throws ComponentDoesNotExistException {
        num.setModulus();
        assertEquals(-(Math.PI / 2), num.getModulus());
    }

    @Test
    void TestComplexPartEqualToZero() throws ComponentDoesNotExistException {
        num3.setModulus();
        assertEquals(0, num3.getModulus());
    }

    @Test
    void generalModulusCalculation() throws ComponentDoesNotExistException {
        num4.setModulus();
        assertEquals(-0.9517586414835069, num4.getModulus());
    }

    @Test
    void secondQuadrantTest() throws ComponentDoesNotExistException {
        num5.setModulus();
        assertEquals(2.9275319700259717d, num5.getModulus());
    }

    @Test
    void thirdQuadrantTest() throws ComponentDoesNotExistException {
        num6.setModulus();
        assertEquals(-2.9275319700259717d, num6.getModulus());
    }
}
