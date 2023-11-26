package ch.hslu.oop.sw10;

import java.util.EventListener;

public interface TemperatureEventListener extends EventListener {
    public void temperatureExtremaChange(TemperatureEvent evt);
}
