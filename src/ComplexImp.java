import Exceptions.ComponentDoesNotExistException;
import Exceptions.*;

public class ComplexImp implements Complex {
    /**
     * This class has the target of create and operate with complex numbers.
     * By default, when creating a new complex, is going to be created as a complex number in binomial format,
     * but the number can be turned into a polar complex number.
     **/
    /*Binomial format*/
    private Double realPart;
    private Double complexPart;

    /*Polar format*/
    private Double argument;
    private Double modulus;

    public ComplexImp(Double realPart, Double complexPart) {
        /**
         * This constructor creates a new Complex number, with its components initialized to
         * the parameters.
         **/
        this.realPart = realPart;
        this.complexPart = complexPart;
        this.argument = null;
        this.modulus = null;
    }

    public ComplexImp() {
        /**
         * This constructor creates a new Complex number, with its components initialized to 0.
         * */
        this.realPart = Double.valueOf(0f);
        this.complexPart = Double.valueOf(0);
        this.argument = null;
        this.modulus = null;
    }

    @Override
    public Complex add(Complex num) {
        /**
         * This function adds two binary numbers, in binomial format, and returns a new
         * complex number with the result.
         **/
        Complex res = new ComplexImp();
        res.setRealPart(this.realPart + num.getRealPart());
        res.setComplexPart(this.complexPart + num.getComplexPart());
        return res;
    }

    @Override
    public Complex subtract(Complex num) {
        /**
         * This function performs the subtraction operation and returns a new complex with the result
         **/
        Complex res = new ComplexImp();
        res.setRealPart(this.realPart - num.getRealPart());
        res.setComplexPart(this.complexPart - num.getComplexPart());
        return res;
    }

    @Override
    public Complex multiply(Complex num) {
        /**
         * This function multiplies two complex numbers and returns a new one with the result.
         **/
        Complex res = new ComplexImp();
        Double newReal = (this.realPart * num.getRealPart()) - (this.complexPart * num.getComplexPart());
        Double newComplex = (this.realPart * num.getComplexPart()) + (this.complexPart * num.getRealPart());
        res.setRealPart(newReal);
        res.setComplexPart(newComplex);
        return res;
    }

    @Override
    public Complex divide(Complex num) throws ArithmeticException, NullPointerException {
        /**
         * This function performs the division operation and returns a new complex with the result.
         **/
        if (num.getRealPart() == 0d && num.getComplexPart() == 0d) {
            throw new ArithmeticException("Dividing by 0");
        }
        Complex res = new ComplexImp();
        Double denominator = (num.getRealPart() * num.getRealPart()) + (num.getComplexPart() * num.getComplexPart());
        Double newReal = ((this.realPart * num.getRealPart()) + (this.complexPart * num.getComplexPart())) / denominator;
        Double newComplex = ((this.complexPart * num.getRealPart()) - (this.realPart * num.getComplexPart())) / denominator;
        res.setRealPart(newReal);
        res.setComplexPart(newComplex);
        return res;
    }

    @Override
    public String getNumber(Complex num) throws ComponentDoesNotExistException {
        /**
         * This function returns a String with the parameter's data. If the
         * polar components are calculated, returns it too.
         **/
        String res = "Complex number data { " +
                "real part = " + this.realPart +
                ", complex part = " + this.complexPart;
        if (num.getArgument() == null && num.getModulus() == null) {
            String res2 = res + " }";
            return res2;
        } else {
            String res2 = res + ", argument = " + num.getArgument() +
                    ", modulus = " + num.getModulus();
            return res2;
        }
    }

    @Override
    public Double getRealPart() {
        /**
         * This function returns the Double value of the real part of the number.
         **/
        return this.realPart;
    }

    @Override
    public Double getComplexPart() {
        /**
         * This function returns the Double value of the complex part of the number.
         **/
        return this.complexPart;
    }

    @Override
    public Double getArgument() throws ComponentDoesNotExistException {
        /**
         * If it's calculated, returns the Double value of the argument. Otherwise, returns null.
         **/
        if (this.argument == null) {
            throw new ComponentDoesNotExistException("Argument is not calculated");
        }
        return this.argument;
    }

    @Override
    public Double getModulus() throws ComponentDoesNotExistException {
        /**
         * If it's calculated, returns the Double value of the modulus in radians. Otherwise, returns null.
         **/
        if (this.modulus == null) {
            throw new ComponentDoesNotExistException("Modulus is not calculated");
        }
        return this.modulus;
    }

    @Override
    public void setRealPart(Double newRealPart) {
        /**
         * Changes the real part for the specified new real part.
         **/
        this.realPart = newRealPart;
    }

    @Override
    public void setComplexPart(Double newComplexPart) {
        /**
         * Changes the complex part for the specified new complex part.
         **/
        this.complexPart = newComplexPart;
    }

    @Override
    public void setArgument(Double newArgument) {
        /**
         * Changes the argument for the specified new argument.
         **/
        this.argument = newArgument;
    }

    @Override
    public void setModulus(Double newModulus) {
        /**
         * Changes the modulus for the specified new modulus.
         **/
        this.modulus = newModulus;
    }

    @Override
    public void setModulus() {
        /**
         * This function calculates the corresponding argument for the complex number.
         * The binomial components are needed.
         **/
        if (this.realPart == 0) {
            if (this.complexPart > 0) {
                this.modulus = Math.PI / 2;
            } else if (this.complexPart < 0) {
                this.modulus = -(Math.PI / 2);
            } else if (this.complexPart.doubleValue() == 0d) {
                this.modulus = 0d;
            }
        } else if (this.realPart < 0 && this.complexPart > 0) {
            this.modulus = Math.PI + Math.atan(this.complexPart / this.realPart);
        } else if (this.realPart < 0 && this.complexPart < 0) {
            this.modulus = Math.atan(this.complexPart / this.realPart) - Math.PI;
        } else {
            this.modulus = Math.atan(this.complexPart / this.realPart);
        }

    }

    @Override
    public void setArgument() {
        /**
         * This function calculates the corresponding argument for the complex number.
         * Binomial components are needed.
         **/
        this.argument = Math.sqrt((this.realPart * this.realPart) + (this.complexPart * this.complexPart));
    }


}
