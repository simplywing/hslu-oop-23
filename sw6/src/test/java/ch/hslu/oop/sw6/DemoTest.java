/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ch.hslu.oop.sw6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author JoëlAmmann
 */
public class DemoTest {
    
    @Test
    public void testMaxNegative() {
        int maxVal = Demo.max(-3, -3, 4);
        assertEquals(4, maxVal);
    }
    
    @Test
    public void testMaxAllEqual() {
        int maxVal = Demo.max(0, 0, 0);
        assertEquals(0, maxVal);
    }

    @Test
    public void testMaxPositive() {
        int maxVal = Demo.max(45, 0, 10);
        assertEquals(45, maxVal);
    }

    
}
