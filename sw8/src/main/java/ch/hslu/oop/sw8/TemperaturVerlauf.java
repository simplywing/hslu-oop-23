package ch.hslu.oop.sw8;

import java.util.List;
import java.util.Optional;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public final class TemperaturVerlauf implements TemperatureHistory {

    private final Collection<Temperature> temps = new HashSet<>();

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
    public Temperature getMax() {
        return Collections.max(this.temps);
    }

    @Override
    public Temperature getMin() {
        return Collections.min(this.temps);
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
