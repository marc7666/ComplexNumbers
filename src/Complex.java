import Exceptions.ComponentDoesNotExistException;
import Exceptions.*;

public interface Complex {
    Complex add(Complex num);

    Complex subtract(Complex num);

    Complex multiply(Complex num);

    Complex divide(Complex num);

    String getNumber(Complex num) throws ComponentDoesNotExistException;

    Double getRealPart();

    Double getComplexPart();

    Double getArgument() throws ComponentDoesNotExistException;

    Double getModulus() throws ComponentDoesNotExistException;

    void setRealPart(Double newRealPart);

    void setComplexPart(Double newComplexPart);

    void setArgument(Double newArgument);

    void setModulus(Double newModulus);

    void setModulus();

    void setArgument();
}
