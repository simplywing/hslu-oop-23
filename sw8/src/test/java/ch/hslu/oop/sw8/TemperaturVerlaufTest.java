/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ch.hslu.oop.sw8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author JoëlAmmann
 */
public class TemperaturVerlaufTest {

    @Test
    public void testTemperaturVerlaufAdd() {
        TemperatureHistory myTempVerlauf = new TemperaturVerlauf();

        myTempVerlauf.add(new Temperature(45f));
        myTempVerlauf.add(new Temperature(-3f));

        assertEquals(2, myTempVerlauf.getCount());
    }

    @Test
    public void testTemperaturVerlaufClear() {
        TemperatureHistory myTempVerlauf = new TemperaturVerlauf();

        myTempVerlauf.add(new Temperature(45f));
        myTempVerlauf.add(new Temperature(-3f));
        myTempVerlauf.clear();

        assertEquals(0, myTempVerlauf.getCount());
    }

    @Test
    public void testTemperaturVerlaufGetMax() {
        TemperatureHistory myTempVerlauf = new TemperaturVerlauf();

        myTempVerlauf.add(new Temperature(45f));
        myTempVerlauf.add(new Temperature(-3f));
        assertEquals(45f, myTempVerlauf.getMax().getCelsius());
    }

    @Test
    public void testTemperaturVerlaufGetMin() {
        TemperatureHistory myTempVerlauf = new TemperaturVerlauf();

        myTempVerlauf.add(new Temperature(45f));
        myTempVerlauf.add(new Temperature(-3f));
        myTempVerlauf.add(new Temperature(-3f));
        assertEquals(-3f, myTempVerlauf.getMin().getCelsius());
    }

    @Test
    public void testTemperaturVerlaufAverage() {
        TemperatureHistory myTempVerlauf = new TemperaturVerlauf();

        myTempVerlauf.add(new Temperature(45f));
        myTempVerlauf.add(new Temperature(-3f));
        myTempVerlauf.add(new Temperature(100.5f));
        assertEquals(47.5f, myTempVerlauf.getAverage().get().getCelsius());
    }

    @Test
    public void testTemperaturVerlaufAverageEmpty() {
        TemperatureHistory myTempVerlauf = new TemperaturVerlauf();

        myTempVerlauf.add(new Temperature(45f));
        myTempVerlauf.add(new Temperature(-3f));
        myTempVerlauf.add(new Temperature(100.5f));
        myTempVerlauf.clear();
        assertEquals(true, myTempVerlauf.getAverage().isEmpty());
    }
}
