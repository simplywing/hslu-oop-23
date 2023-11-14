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
public class PointTest {

    @Test
    public void testMoveRelativeVector() {
        Point point = new Point(-1f, -2f);
        point.moveRelative(3f, 6f);
        assertEquals(2, point.getX());
        assertEquals(4, point.getY());
    }

    @Test
    public void testMoveRelativePoint() {
        Point point = new Point(6f, -10f);
        Point moveVector = new Point(-2f, 11f);

        point.moveRelative(moveVector);
        assertEquals(4, point.getX());
        assertEquals(1, point.getY());
    }
    
    @Test
    public void testMoveRelativePolar(){
        Point point = new Point(4f, -3f);
        
        //angle of 135 deg
        double angle = 3 * Math.PI /4;
        float length = 2.828427f;
        
        point.moveRelative(length, angle);
        assertEquals(2f, point.getX());
        assertEquals(-1f, point.getY());
    }

}
