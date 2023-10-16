/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ch.hslu.oop.sw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author JoëlAmmann
 */
public class PointTest {
    
    public PointTest() {
    }  
    
    @org.junit.jupiter.api.Test
    public void testGetQuadrant1() {
        System.out.println("getQuadrant -> 1");
        Point instance = new Point(1,1);
        int expResult = 1;
        int result = instance.getQuadrant();
        assertEquals(expResult, result, 0);
    }

    public void testGetQuadrant2() {
        System.out.println("getQuadrant -> 2");
        Point instance = new Point(-1,1);
        int expResult = 2;
        int result = instance.getQuadrant();
        assertEquals(expResult, result, 0);
    }

    public void testGetQuadrant3() {
        System.out.println("getQuadrant -> 3");
        Point instance = new Point(-1,-1);
        int expResult = 3;
        int result = instance.getQuadrant();
        assertEquals(expResult, result, 0);
    }

    public void testGetQuadrant4() {
        System.out.println("getQuadrant -> 4");
        Point instance = new Point(1,-1);
        int expResult = 4;
        int result = instance.getQuadrant();
        assertEquals(expResult, result, 0);
    }
    
}
