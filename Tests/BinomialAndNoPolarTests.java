import Exceptions.ComponentDoesNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinomialAndNoPolarTests implements TestsInterface {
    Complex num;

    @BeforeEach
    public void setup() {
        this.num = new ComplexImp(25d, 16d);
    }

    @Test
    void getArgumentThrowsTest() {
        assertThrows(ComponentDoesNotExistException.class,
                () -> this.num.getArgument());
    }

    @Test
    void getModulusThrowsTest() {
        assertThrows(ComponentDoesNotExistException.class,
                () -> this.num.getModulus());
    }
}
