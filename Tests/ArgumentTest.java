import Exceptions.ComponentDoesNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgumentTest implements TestsInterface {
    Complex num;

    @Override
    @BeforeEach
    public void setup() {
        this.num = new ComplexImp(12.33d, -78.5d);
    }

    @Test
    void argumentTest() throws ComponentDoesNotExistException {
        this.num.setArgument();
        assertEquals(79.46243703788602d, num.getArgument());
    }
}
