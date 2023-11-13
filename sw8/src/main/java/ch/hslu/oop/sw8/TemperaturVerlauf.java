package ch.hslu.oop.sw8;

import java.util.List;
import java.util.Optional;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;

public final class TemperaturVerlauf implements MeasurementHistory<Temperature> {

    private final Collection<Temperature> temps = new ArrayList<>();

    public TemperaturVerlauf() {

    }

    @Override
    public void add(Temperature temp) {
        this.temps.add(temp);
    }

    @Override
    public void clear() {
        this.temps.clear();
    }

    @Override
    public int getCount() {
        return this.temps.size();
    }

    @Override
    public Optional<Temperature> getMax() {
        if(this.getCount() > 0){
            return Optional.of(Collections.max(this.temps));
        } 
        else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Temperature> getMin() {
        if(this.getCount() > 0){
            return Optional.of(Collections.min(this.temps));
        } 
        else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Temperature> getAverage() {
        if(this.temps.size() < 1){
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
