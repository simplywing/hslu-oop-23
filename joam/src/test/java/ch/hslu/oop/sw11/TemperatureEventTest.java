package ch.hslu.oop.sw11;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureEventTest {
    private static final Logger LOG = LoggerFactory.getLogger(TemperatureEventTest.class);
    @Test
    public void testTemperatureEvent(){
        final var evt = new TemperatureEvent(this, TemperatureEventType.MAX, Temperature.fromCelsius(30));

        assertEquals(TemperatureEventType.MAX, evt.getType());
        assertEquals(30, evt.getValue().getCelsius());

        LOG.info(evt.toString());
    }
}