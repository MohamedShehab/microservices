package com.example.springbootjunitdemo;

import com.example.springbootjunitdemo.service.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testCal() {
        Assertions.assertEquals(10, calculator.multiplie(2, 5));
    }

    @Test
    public void testCalDivideWithZero() {
        Exception exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(4, 0);
        });
        Assertions.assertTrue(exception.getMessage().contains("/ by zero"));
    }
}
