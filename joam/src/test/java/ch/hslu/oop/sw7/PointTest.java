/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ch.hslu.oop.sw7;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

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

    @Test
    public void testPointEqualsContract() {
        EqualsVerifier.forClass(Point.class)
        .suppress(Warning.NONFINAL_FIELDS)
        .verify();
    }

    @Test
    public void testPointCompareToEquals1() {
        Point p1 = new Point(4f, -3f);
        Point p2 = p1;

        assertEquals(0, p1.compareTo(p2));
    }

    @Test
    public void testPointCompareToEquals2() {
        Point p1 = new Point(4f, -3f);
        Point p2 = new Point(4f, -2f);

        assertEquals(0, p1.compareTo(p2));
    }

    @Test
    public void testPointCompareToSmaller() {
        Point p1 = new Point(-2f, -3f);
        Point p2 = new Point(6f, -2f);

        assertEquals(-1, p1.compareTo(p2));
    }

    @Test
    public void testPointCompareToGreater() {
        Point p1 = new Point(19f, -3f);
        Point p2 = new Point(0f, -2f);

        assertEquals(1, p1.compareTo(p2));
    }

}
