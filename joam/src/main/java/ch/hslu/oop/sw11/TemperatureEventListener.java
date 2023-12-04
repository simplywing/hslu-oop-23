package ch.hslu.oop.sw11;

import java.util.EventListener;

/**
 * Event listener for TemperatureHistory related Events.
 */
public interface TemperatureEventListener extends EventListener {
    /**
     * This method accepts a temperature event as a parameter and processes it.
     * @param event The event
     */
    public void temperatureExtremaChanged(TemperatureEvent event);
}
