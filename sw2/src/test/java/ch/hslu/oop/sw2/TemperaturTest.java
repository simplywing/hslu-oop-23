/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ch.hslu.oop.sw2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author JoëlAmmann
 */
public class TemperaturTest {
    
    public TemperaturTest() {
    }

    /**
     * Test of getAmbientTemperatureKelvin method, of class Temperatur.
     */
    @org.junit.jupiter.api.Test
    public void testGetAmbientTemperatureKelvin() {
        System.out.println("getAmbientTemperatureKelvin");
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
        System.out.println("getAmbientTemperatureFarenheit");
        Temperatur instance = new Temperatur(0f);
        float expResult = 32f;
        float result = instance.getAmbientTemperatureFarenheit();
        assertEquals(expResult, result, 0);
    }
    
    
}
