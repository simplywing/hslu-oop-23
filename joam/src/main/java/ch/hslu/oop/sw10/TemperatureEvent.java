package ch.hslu.oop.sw10;

import java.util.EventObject;

public final class TemperatureEvent extends EventObject {

    public final TemperatureEventType type;
    public final Temperature temperature;

    public TemperatureEvent(Object source, TemperatureEventType type, Temperature temperature){
        super(source);
        this.type = type;
        this.temperature = temperature;
    }

    @Override
    public String toString(){
        return String.format("TemperatureEvent[type=%s, temperature=%s]", this.type, this.temperature);
    }
}
