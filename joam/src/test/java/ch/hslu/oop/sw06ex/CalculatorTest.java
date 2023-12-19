/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ch.hslu.oop.sw06ex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author JoëlAmmann
 */
public class CalculatorTest {

    @Test
    public void testAdditionZero() {
        Calculator calc = new Calculator();
        double sum = calc.addition(0d, 0d);
        assertEquals(0, sum);
    }

    @Test
    public void testAdditionSame() {
        Calculator calc = new Calculator();
        double sum = calc.addition(2.5d, 2.5d);
        assertEquals(5, sum);
    }

    @Test
    public void testAdditionNegative() {
        Calculator calc = new Calculator();
        double sum = calc.addition(-99d, -1d);
        assertEquals(-100d, sum);
    }

    @Test
    public void testAdditionNegativeAndPostivieParam() {
        Calculator calc = new Calculator();
        double sum = calc.addition(-9d, 60d);
        assertEquals(51d, sum);
    }

    @Test 
    public void testAdditionMaxLongMinLong(){
        Calculator calc = new Calculator();
        long sum = calc.addition(Long.MAX_VALUE, Long.MIN_VALUE);
        assertEquals(-1l, sum);
    }

    @Test 
    public void testAdditionMaxLong(){
        Calculator calc = new Calculator();
        long sum = calc.addition(Long.MAX_VALUE, Long.MAX_VALUE);
        assertEquals(-2l, sum);
    }

}
