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
        MeasurementHistory<Temperature> myTempVerlauf = new TemperaturVerlauf();

        myTempVerlauf.add(new Temperature(45f));
        myTempVerlauf.add(new Temperature(45f));
        myTempVerlauf.add(new Temperature(-3f));

        assertEquals(3, myTempVerlauf.getCount());
    }

    @Test
    public void testTemperaturVerlaufClear() {
        MeasurementHistory<Temperature> myTempVerlauf = new TemperaturVerlauf();

        myTempVerlauf.add(new Temperature(45f));
        myTempVerlauf.add(new Temperature(-3f));
        myTempVerlauf.clear();

        assertEquals(0, myTempVerlauf.getCount());
    }

    @Test
    public void testTemperaturVerlaufGetMax() {
        MeasurementHistory<Temperature> myTempVerlauf = new TemperaturVerlauf();

        myTempVerlauf.add(new Temperature(45f));
        myTempVerlauf.add(new Temperature(-3f));
        assertEquals(45f, myTempVerlauf.getMax().get().getCelsius());
    }

    @Test
    public void testTemperaturVerlaufGetMin() {
        MeasurementHistory<Temperature> myTempVerlauf = new TemperaturVerlauf();

        myTempVerlauf.add(new Temperature(45f));
        myTempVerlauf.add(new Temperature(-3f));
        myTempVerlauf.add(new Temperature(-3f));
        assertEquals(-3f, myTempVerlauf.getMin().get().getCelsius());
    }

    @Test
    public void testTemperaturVerlaufGetMinEmpty() {
        MeasurementHistory<Temperature> myTempVerlauf = new TemperaturVerlauf();

        if(myTempVerlauf.getMin().isPresent())
        {
            fail("TemperaturVerlauf is empty, therefore getMin() should return an empty Optional");
        }
    }

    @Test
    public void testTemperaturVerlaufAverage() {
        MeasurementHistory<Temperature> myTempVerlauf = new TemperaturVerlauf();

        myTempVerlauf.add(new Temperature(45f));
        myTempVerlauf.add(new Temperature(-3f));
        myTempVerlauf.add(new Temperature(100.5f));
        assertEquals(47.5f, myTempVerlauf.getAverage().get().getCelsius());
    }

    @Test
    public void testTemperaturVerlaufAverageEmpty() {
        MeasurementHistory<Temperature> myTempVerlauf = new TemperaturVerlauf();

        myTempVerlauf.add(new Temperature(45f));
        myTempVerlauf.add(new Temperature(-3f));
        myTempVerlauf.add(new Temperature(100.5f));
        myTempVerlauf.clear();
        assertEquals(true, myTempVerlauf.getAverage().isEmpty());
    }
}
