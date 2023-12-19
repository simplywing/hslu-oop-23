package ch.hslu.oop.sw11ex;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureMeasurementParserTest {

    private static final Logger LOG = LoggerFactory.getLogger(TemperatureMeasurementParserTest.class);

    @Test
    void getFilePath() {
        var parser = new TemperatureMeasurementParser();
        parser.setFilePath("resources\\netatmo-export-202301-202304.csv");
        assertEquals("resources\\netatmo-export-202301-202304.csv", parser.getFilePath());
    }

    @Test
    void printMeasurements() {
        var parser = new TemperatureMeasurementParser();
        parser.setFilePath("C:\\Workspace\\GitHub\\hslu-oop-23\\joam\\src\\main\\resources\\netatmo-export-202301-202304.csv");
        parser.printMeasurements();
    }

    @Test
    void getTemperatureMeasurementHistory() {
        TemperatureMeasurementParser parser = TemperatureMeasurementParser
                .of("C:\\Workspace\\GitHub\\hslu-oop-23\\joam\\src\\main\\resources\\netatmo-export-202301-202304.csv");

        MeasurementHistory<TemperatureMeasurement> history = parser.getTemperatureMeasurementHistory();

        var max = history.getMax();
        var min = history.getMin();
        var avg = history.getAverage();

        if (max.isPresent()) {
            LOG.info("Max Measurement: {} at {}", max.get().measurement().toString(), max.get().timestamp().toString());
        }

        if (min.isPresent()) {
            LOG.info("Min Measurement: {} at {}", min.get().measurement().toString(), min.get().timestamp().toString());
        }

        // alternate variant in functional style
        avg.ifPresent(temperatureMeasurement
                -> LOG.info("Average Temp: {}", temperatureMeasurement.measurement().toString())
        );

        assertEquals(32.8f, max.get().measurement().getCelsius(), 0.001);
        assertEquals(LocalDateTime.parse("2023-04-21T17:22:54"), max.get().timestamp());

        assertEquals(-8.4f, min.get().measurement().getCelsius(), 0.001);
        assertEquals(LocalDateTime.parse("2023-02-27T07:01:13"), min.get().timestamp());

    }
}