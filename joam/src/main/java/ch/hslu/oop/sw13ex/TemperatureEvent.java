package ch.hslu.oop.sw13ex;


import java.util.EventObject;

public final class TemperatureEvent extends EventObject {

    private final TemperatureEventType type;
    private final Temperature temperature;

    public TemperatureEvent(Object source, TemperatureEventType type, Temperature temperature){
        super(source);
        this.type = type;
        this.temperature = temperature;
    }

    public TemperatureEventType getType(){
        return this.type;
    }

    public Temperature getValue(){
        return this.temperature;
    }

    @Override
    public String toString(){
        return String.format("TemperatureEvent[type=%s, temperature=%s]", this.type, this.temperature);
    }
}

