package ch.hslu.oop.sw10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public final class TemperatureHistory implements MeasurementHistory<Temperature> {

    private final Collection<Temperature> temps = new ArrayList<>();
    private Temperature minTemp;
    private Temperature maxTemp;

    private final List<TemperatureEventListener> listeners = new ArrayList<>();

    private static final Logger LOG = LoggerFactory.getLogger(TemperatureHistory.class);

    public TemperatureHistory() {

    }

    @Override
    public void add(Temperature temp) {
        LOG.debug(String.format("adding temperature: %s", temp.toString()));

        this.testTemperatureExtrema(temp);
        this.temps.add(temp);
    }

    @Override
    public void clear() {
        LOG.debug("clearing temperatures");

        this.minTemp = null;
        this.maxTemp = null;
        this.temps.clear();
    }

    @Override
    public int getCount() {
        return this.temps.size();
    }

    @Override
    public Optional<Temperature> getMax() {
        if(this.getCount() > 0){
            return Optional.of(new Temperature(Collections.max(this.temps)));
        } 
        else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Temperature> getMin() {
        if(this.getCount() > 0){
            return Optional.of(new Temperature(Collections.min(this.temps)));
        } 
        else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Temperature> getAverage() {
        if(this.temps.isEmpty()){
            return Optional.empty();
        }

        double tempSum = 0.0;
        for(final Temperature t : this.temps) {
            tempSum += t.getCelsius();
        }
        float average = (float) (tempSum / this.temps.size());

        return Optional.of(new Temperature(average));
    }

    public void addTemperatureEventListener(TemperatureEventListener listener){
        if(null != listener)
            this.listeners.add(listener);
    }

    public void removeTemperatureEventListener(TemperatureEventListener listener){
        if(null != listener)
            this.listeners.remove(listener);
    }

    public void fireTemperatureEvent(TemperatureEvent evt){
        for (final TemperatureEventListener listener:
             this.listeners ) {
            listener.temperatureExtremaChange(evt);
        }
    }

    private void testTemperatureExtrema(Temperature temp){
        if (null == temp){
            return;
        }

        boolean newMin = false;
        boolean newMax = false;

        if(null == this.minTemp){
            this.minTemp = temp;
            newMin = true;
        }
        if(null == this.maxTemp){
            this.maxTemp = temp;
            newMax = true;
        }

        if(temp.compareTo(this.minTemp) < 0) {
            this.minTemp = new Temperature(temp);
            newMin = true;
        }

        if (temp.compareTo(this.maxTemp) > 0){
            this.maxTemp = new Temperature(temp);
            newMax = true;
        }

        if (newMin){
            fireTemperatureEvent(new TemperatureEvent(
                    this,
                    TemperatureEventType.MIN,
                    new Temperature(this.minTemp)
            ));
        }

        if (newMax){
            fireTemperatureEvent(new TemperatureEvent(
                    this,
                    TemperatureEventType.MAX,
                    new Temperature(this.maxTemp)
            ));
        }
    }

}
