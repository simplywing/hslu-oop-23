package ch.hslu.oop.sw10ex;

import java.util.EventListener;

/**
 * Event listener for TemperatureHistory related Events.
 */
public interface TemperatureEventListener extends EventListener {
    /**
     * This method accepts a temperature event as a parameter and processes it.
     * @param event The event
     */
    void temperatureExtremaChanged(TemperatureEvent event);
}
