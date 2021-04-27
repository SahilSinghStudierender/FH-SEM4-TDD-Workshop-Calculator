package pt.ipp.isep.dei.examples.tdd.basic.domain;

/**
 * Calculator class.
 * This class is very simple in order to demonstrate how to build test cases for Unit Testing.
 */
public class Calculator {

    /**
     * Sums one operand to the other, returning the result.
     *
     * @param firstOperand  First operand to sum.
     * @param secondOperand Second Operand to sum.
     * @return The sum of firstOperand with secondOperand.
     */
    public int sum(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    public int subtract(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }

    /**
     * Divides the dividend with the divisor, returning the result
     *
     * @param dividend The dividend to use
     * @param divisor  The divisor to use
     * @return Result of the division
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            throw new ArithmeticException();
        return dividend / divisor;
    }

    public int multiply(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }

    public int factorial(int firstOperand) {
        int value = 1;
        int tempFirstOperand = firstOperand;

        if (firstOperand > 0) {
            for (int i = 0; i < tempFirstOperand; i++) {
                value *= firstOperand;
                firstOperand--;
            }
        }

        return value;
    }
}
