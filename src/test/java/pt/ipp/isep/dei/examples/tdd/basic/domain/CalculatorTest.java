package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @BeforeAll
    public static void classSetUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a CalculatorTest class method and takes place before any @Test is executed");
    }

    @AfterAll
    public static void classTearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a CalculatorTest class method and takes place after all @Test are executed");
    }

    @BeforeEach
    public void setUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place before each @Test is executed");
    }

    @AfterEach
    public void tearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place after each @Test is executed");
    }

    @Test
    @Disabled
    public void failingTest() {
        fail("a disabled failing test");
    }

    /**
     * Test to ensure two positive numbers are summed correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange: one positive number (three) and another positive number (two).<p>
     * Act: sum both numbers (three and two).<p>
     * Assert: the result is five.
     */
    @Test
    public void ensureThreePlusTwoEqualsFive() {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int expectedResult = 5;
        int firstOperand = 3;
        int secondOperand = 2;
        int result = 3;

        // Act
        result = new Calculator().sum(firstOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure positive and negative numbers are summed correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arranje a positive number (three) and a negative number (minus two)<p>
     * Act I sum three to minus two<p>
     * Assert the sum result should be one.
     */
    @Test
    public void ensureThreePlusMinusTwoEqualsOne() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = 3;
        int secondOperand = -2;
        int expectedResult = 1;
        int result = 3;

        // Act
        result = new Calculator().sum(firstOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that addition with neutral element results in correct output
     */
    @Test
    public void ensureAdditionWithZeroEqualsSame() {

        int firstOperand = 3;
        int secondOperand = 0;
        int expectedResult = 3;

        int result = new Calculator().sum(firstOperand, secondOperand);
        assertEquals(expectedResult, result);

    }

    /**
     * Test to ensure that addition with inverse element results in correct output
     */
    @Test
    public void ensureAdditionWithMinusSelfEqualsZero() {

        int firstOperand = 5;
        int secondOperand = -5;
        int expectedResult = 0;

        int result = new Calculator().sum(firstOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that addition with integer max value throws an exception
     */
    @Test
    public void ensureAdditionOfMaxIntValueThrowsException() {
        int firstOperand = Integer.MAX_VALUE;
        int secondOperand = 4;

        assertThrows(ArithmeticException.class, () -> {
            new Calculator().sum(firstOperand, secondOperand);
        });
    }


    /**
     * Test to ensure that subtraction with neutral element results in correct output
     */
    @Test
    public void ensureSubtractionWithZeroEqualsSame() {

        int firstOperand = 3;
        int secondOperand = 0;
        int expectedResult = 3;

        int result = new Calculator().subtract(firstOperand, secondOperand);
        assertEquals(expectedResult, result);

    }

    /**
     * Test to ensure that subtraction with inverse element results in correct output
     */
    @Test
    public void ensureSubtractionWithSelfEqualsZero() {

        int firstOperand = 5;
        int secondOperand = 5;
        int expectedResult = 0;

        int result = new Calculator().subtract(firstOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure two numbers are subtracted correctly.
     */
    @Test
    public void ensureThreeMinusTwoEqualsOne() {

        int firstOperand = 3;
        int secondOperand = 2;
        int expectedResult = 1;

        int result = new Calculator().subtract(firstOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that if the second operand is bigger than the first the result is smaller zero
     */
    @Test
    public void ensureThatSubtractionResultIsSmallerZeroIfFirstOperandIsSmaller() {

        int firstOperand = 5;
        int secondOperand = 10;

        int result = new Calculator().subtract(firstOperand, secondOperand);

        assertTrue(result < 0);
    }

    /**
     * Test to ensure that if the second operand is smaller than the first the result is bigger zero
     */
    @Test
    public void ensureThatSubtractionResultIsBiggerZeroIfFirstOperandIsBigger() {

        int firstOperand = 10;
        int secondOperand = 5;

        int result = new Calculator().subtract(firstOperand, secondOperand);

        assertTrue(result > 0);
    }

    /**
     * Test to ensure that subtraction with integer min value throws an exception
     */
    @Test
    public void ensureSubtractionFromMinIntValueThrowsException() {
        int firstOperand = Integer.MIN_VALUE;
        int secondOperand = 4;

        assertThrows(ArithmeticException.class, () -> {
            new Calculator().subtract(firstOperand, secondOperand);
        });
    }

    /**
     * Test to ensure that two integer are divided correctly
     */
    @Test
    public void ensureNineDividedByThreeEqualsThree() {
        int firstOperand = 9;
        int secondOperand = 3;
        int expectedResult = 3;

        int result = new Calculator().divide(firstOperand, secondOperand);

        assertEquals(expectedResult, result);

    }

    /**
     * Test to ensure that the result of the division of two int values leaves no remainder
     */
    @Test
    public void ensureTenDividedByThreeEqualsThree() {
        int firstOperand = 10;
        int secondOperand = 3;
        int expectedResult = 3;

        int result = new Calculator().divide(firstOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that division with zero throws an exception
     */
    @Test
    public void ensureDivisionWithZeroThrowsException() {
        int firstOperand = 14;
        int secondOperand = 0;

        assertThrows(ArithmeticException.class, () -> {
            new Calculator().divide(firstOperand, secondOperand);
        });
    }

    /**
     * Test to ensure that zero divided is zero
     */
    @Test
    public void ensureZeroDividedEqualsZero() {
        int firstOperand = 0;
        int secondOperand = 16;
        int expectedResult = 0;

        int result = new Calculator().divide(firstOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that multiplication with two positive integers works correctly
     */
    @Test
    public void ensureTwoMultipliedTwoEqualsFour() {
        int firstOperand = 2;
        int secondOperand = 2;
        int expectedResult = 4;

        int result = new Calculator().multiply(firstOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that multiplication with one positive one negative integers works correctly
     */
    @Test
    public void ensureTwoMultipliedMinusTwoEqualsMinusFour() {
        int firstOperand = 2;
        int secondOperand = -2;
        int expectedResult = -4;

        int result = new Calculator().multiply(firstOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that multiplication with two negative integers works correctly
     */
    @Test
    public void ensureMinusTwoMultipliedMinusTwoEqualsFour() {
        int firstOperand = -2;
        int secondOperand = -2;
        int expectedResult = 4;

        int result = new Calculator().multiply(firstOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that multiplication with zero equals zero
     */
    @Test
    public void ensureMultiplicationWithZeroEqualsZero() {
        int firstOperand = 145;
        int secondOperand = 0;
        int expectedResult = 0;

        int result = new Calculator().multiply(firstOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that multiplication with neutral element equals self
     */
    @Test
    public void ensureMultiplicationWithOneEqualsSame() {
        int firstOperand = 145;
        int secondOperand = 1;
        int expectedResult = 145;

        int result = new Calculator().multiply(firstOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that multiplication with integer max value throws an exception
     */
    @Test
    public void ensureMultiplicationWithMaxIntValueThrowsException() {
        int firstOperand = Integer.MAX_VALUE;
        int secondOperand = 4;

        assertThrows(ArithmeticException.class, () -> {
            new Calculator().multiply(firstOperand, secondOperand);
        });
    }

    /**
     * Test to ensure that multiplication with integer min value throws an exception
     */
    @Test
    public void ensureMultiplicationWithMinIntValueThrowsException() {
        int firstOperand = Integer.MIN_VALUE;
        int secondOperand = 4;

        assertThrows(ArithmeticException.class, () -> {
            new Calculator().multiply(firstOperand, secondOperand);
        });
    }

    /**
     * Test to ensure that factorial with a positive integer works fine
     */
    @Test
    public void ensureFactorialWithTwoEqualsTwo() {
        int firstOperand = 2;
        int expectedResult = 2;

        int result = new Calculator().factorial(firstOperand);

        assertEquals(expectedResult, result);
    }

    /**
     * Another test to ensure that factorial with a positive integer works fine
     */
    @Test
    public void ensureFactorialWithThreeEqualsSix() {
        int firstOperand = 3;
        int expectedResult = 6;

        int result = new Calculator().factorial(firstOperand);

        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure that factorial with a negative number will result to an exception
     */
    @Test
    public void ensureFactorialWithNegativeNumberThrowsException() {
        int firstOperand = -1;

        assertThrows(ArithmeticException.class, () -> {
            new Calculator().factorial(firstOperand);
        });
    }

    /**
     * Test to ensure that factorial with zero will result to one
     */
    @Test
    public void ensureFactorialWithZeroEqualsOne() {
        int firstOperand = 0;
        int expectedResult = 1;

        int result = new Calculator().factorial(firstOperand);

        assertEquals(expectedResult, result);
    }

    // This Test Case will run for a long time, since it will iterate through all the numbers!

//    @Test
//    public void ensureFactorialWithMaxIntValueThrowsException() {
//        int firstOperand = Integer.MAX_VALUE;
//
//        assertThrows(ArithmeticException.class, () -> {
//            new Calculator().factorial(firstOperand);
//        });
//    }

}



