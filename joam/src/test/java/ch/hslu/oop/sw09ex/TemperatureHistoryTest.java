package ch.hslu.oop.sw09ex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author JoëlAmmann
 */
public class TemperatureHistoryTest {

    @Test
    public void testTemperatureHistoryAdd() {
        MeasurementHistory<Temperature> myMeasurementHistory = new TemperatureHistory();

        myMeasurementHistory.add(new Temperature(45f));
        myMeasurementHistory.add(new Temperature(45f));
        myMeasurementHistory.add(new Temperature(-3f));

        assertEquals(3, myMeasurementHistory.getCount());
    }

    @Test
    public void testTemperatureHistoryClear() {
        MeasurementHistory<Temperature> myMeasurementHistory = new TemperatureHistory();

        myMeasurementHistory.add(new Temperature(45f));
        myMeasurementHistory.add(new Temperature(-3f));
        myMeasurementHistory.clear();

        assertEquals(0, myMeasurementHistory.getCount());
    }

    @Test
    public void testTemperatureHistoryGetMax() {
        MeasurementHistory<Temperature> myMeasurementHistory = new TemperatureHistory();

        myMeasurementHistory.add(new Temperature(45f));
        myMeasurementHistory.add(new Temperature(-3f));
        assertEquals(45f, myMeasurementHistory.getMax().get().getCelsius(), 0.001f);
    }

    @Test
    public void testTemperatureHistoryGetMin() {
        MeasurementHistory<Temperature> myMeasurementHistory = new TemperatureHistory();

        myMeasurementHistory.add(new Temperature(45f));
        myMeasurementHistory.add(new Temperature(-3f));
        myMeasurementHistory.add(new Temperature(-3f));
        assertEquals(-3f, myMeasurementHistory.getMin().get().getCelsius(), 0.001f);
    }

    @Test
    public void testTemperatureHistoryGetMinEmpty() {
        MeasurementHistory<Temperature> myMeasurementHistory = new TemperatureHistory();

        if(myMeasurementHistory.getMin().isPresent())
        {
            fail("MeasurementHistory is empty, therefore getMin() should return an empty Optional");
        }
    }

    @Test
    public void testTemperatureHistoryAverage() {
        MeasurementHistory<Temperature> myMeasurementHistory = new TemperatureHistory();

        myMeasurementHistory.add(new Temperature(45f));
        myMeasurementHistory.add(new Temperature(-3f));
        myMeasurementHistory.add(new Temperature(100.5f));
        assertEquals(47.5f, myMeasurementHistory.getAverage().get().getCelsius(), 0.001f);
    }

    @Test
    public void testTemperatureHistoryAverageEmpty() {
        MeasurementHistory<Temperature> myMeasurementHistory = new TemperatureHistory();

        myMeasurementHistory.add(new Temperature(45f));
        myMeasurementHistory.add(new Temperature(-3f));
        myMeasurementHistory.add(new Temperature(100.5f));
        myMeasurementHistory.clear();
        assertTrue(myMeasurementHistory.getAverage().isEmpty());
    }
}
