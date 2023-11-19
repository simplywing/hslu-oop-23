package ch.hslu.oop.sw9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public final class TemperatureHistory implements MeasurementHistory<Temperature> {

    private final Collection<Temperature> temps = new ArrayList<>();

    private static final Logger LOG = LoggerFactory.getLogger(TemperatureHistory.class);

    public TemperatureHistory() {

    }

    @Override
    public void add(Temperature temp) {
        LOG.debug(String.format("adding temperature: %s", temp.toString()));
        this.temps.add(temp);
    }

    @Override
    public void clear() {
        LOG.debug("clearing temperatures");
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
}
