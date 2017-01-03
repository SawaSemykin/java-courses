package ru.parsentev.calculator;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alexander on 02.01.2017.
 */
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void initTest() {
        calculator = new Calculator();
    }

    @After
    public void afterTest() {
        calculator = null;
    }

    @Test
    public void addition() throws Exception {
        calculator.addition(1.0, 1.0);
        Assert.assertEquals(2.0, calculator.getResult());
        calculator.addition(-1.0);
        Assert.assertEquals(1.0, calculator.getResult());
    }

    @Test
    public void subtraction() throws Exception {
        calculator.subtraction(3.0, 2.5);
        Assert.assertEquals(0.5, calculator.getResult());
        calculator.setMemoryEmpty(false);
        calculator.subtraction(0.2);
        Assert.assertEquals(0.3, calculator.getResult());

    }

    @Test
    public void multiplication() throws Exception {
        calculator.multiplication(4, 4);
        Assert.assertEquals(16.0, calculator.getResult());
        calculator.setMemoryEmpty(false);
        calculator.multiplication(4);
        Assert.assertEquals(64.0, calculator.getResult());
    }

    @Test
    public void division() throws Exception {
        calculator.division(6, 3);
        Assert.assertEquals(2.0, calculator.getResult());
        calculator.setMemoryEmpty(false);
        calculator.division(0);
        Assert.assertEquals(0, calculator.getResult());
    }

}