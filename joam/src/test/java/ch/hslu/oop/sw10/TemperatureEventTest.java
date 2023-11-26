package ch.hslu.oop.sw10;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureEventTest {

    private static final Logger LOG = LoggerFactory.getLogger(TemperatureEventTest.class);
    @Test
    public void testTemperatureEvent(){
        final var evt = new TemperatureEvent(this, TemperatureEventType.MAX, Temperature.fromCelsius(30));

        assertEquals(TemperatureEventType.MAX, evt.type);
        assertEquals(30, evt.temperature.getCelsius());

        LOG.info(evt.toString());
    }
}