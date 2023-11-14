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
        MeasurementHistory<Temperature> myMeasurementHistory = new TemperaturVerlauf();

        myMeasurementHistory.add(new Temperature(45f));
        myMeasurementHistory.add(new Temperature(45f));
        myMeasurementHistory.add(new Temperature(-3f));

        assertEquals(3, myMeasurementHistory.getCount());
    }

    @Test
    public void testTemperaturVerlaufClear() {
        MeasurementHistory<Temperature> myMeasurementHistory = new TemperaturVerlauf();

        myMeasurementHistory.add(new Temperature(45f));
        myMeasurementHistory.add(new Temperature(-3f));
        myMeasurementHistory.clear();

        assertEquals(0, myMeasurementHistory.getCount());
    }

    @Test
    public void testTemperaturVerlaufGetMax() {
        MeasurementHistory<Temperature> myMeasurementHistory = new TemperaturVerlauf();

        myMeasurementHistory.add(new Temperature(45f));
        myMeasurementHistory.add(new Temperature(-3f));
        assertEquals(45f, myMeasurementHistory.getMax().get().getCelsius(), 0.001f);
    }

    @Test
    public void testTemperaturVerlaufGetMin() {
        MeasurementHistory<Temperature> myMeasurementHistory = new TemperaturVerlauf();

        myMeasurementHistory.add(new Temperature(45f));
        myMeasurementHistory.add(new Temperature(-3f));
        myMeasurementHistory.add(new Temperature(-3f));
        assertEquals(-3f, myMeasurementHistory.getMin().get().getCelsius(), 0.001f);
    }

    @Test
    public void testTemperaturVerlaufGetMinEmpty() {
        MeasurementHistory<Temperature> myMeasurementHistory = new TemperaturVerlauf();

        if(myMeasurementHistory.getMin().isPresent())
        {
            fail("MeasurementHistory is empty, therefore getMin() should return an empty Optional");
        }
    }

    @Test
    public void testTemperaturVerlaufAverage() {
        MeasurementHistory<Temperature> myMeasurementHistory = new TemperaturVerlauf();

        myMeasurementHistory.add(new Temperature(45f));
        myMeasurementHistory.add(new Temperature(-3f));
        myMeasurementHistory.add(new Temperature(100.5f));
        assertEquals(47.5f, myMeasurementHistory.getAverage().get().getCelsius(), 0.001f);
    }

    @Test
    public void testTemperaturVerlaufAverageEmpty() {
        MeasurementHistory<Temperature> myMeasurementHistory = new TemperaturVerlauf();

        myMeasurementHistory.add(new Temperature(45f));
        myMeasurementHistory.add(new Temperature(-3f));
        myMeasurementHistory.add(new Temperature(100.5f));
        myMeasurementHistory.clear();
        assertTrue(myMeasurementHistory.getAverage().isEmpty());
    }
}
