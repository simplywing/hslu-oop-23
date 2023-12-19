/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ch.hslu.oop.sw02ex;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Joël Ammann
 */
public class TemperaturTest {
    
    public TemperaturTest() {
    }

    /**
     * Test of getAmbientTemperatureKelvin method, of class Temperatur.
     */
    @org.junit.jupiter.api.Test
    public void testGetAmbientTemperatureKelvin() {
        Temperatur instance = new Temperatur(0f);
        float expResult = 273.15f;
        float result = instance.getAmbientTemperatureKelvin();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of getAmbientTemperatureFarenheit method, of class Temperatur.
     */
    @org.junit.jupiter.api.Test
    public void testGetAmbientTemperatureFarenheit() {
        Temperatur instance = new Temperatur(0f);
        float expResult = 32f;
        float result = instance.getAmbientTemperatureFarenheit();
        assertEquals(expResult, result, 0);
    }
}
