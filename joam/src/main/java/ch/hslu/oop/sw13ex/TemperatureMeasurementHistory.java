package ch.hslu.oop.sw13ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public final class TemperatureMeasurementHistory implements MeasurementHistory<TemperatureMeasurement> {

    private final Collection<TemperatureMeasurement> temps = new ArrayList<>();
    private TemperatureMeasurement minTemp;
    private TemperatureMeasurement maxTemp;

    private final List<TemperatureEventListener> listeners = new ArrayList<>();

    private static final Logger LOG = LoggerFactory.getLogger(TemperatureMeasurementHistory.class);

    public TemperatureMeasurementHistory() {

    }

    @Override
    public void add(TemperatureMeasurement temp) {
        LOG.debug(String.format("adding temperature: %s", temp.toString()));

        this.temps.add(temp);
        this.testTemperatureExtrema(temp);
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
    public Optional<TemperatureMeasurement> getMax() {
        if (this.getCount() > 0) {
            return Optional.of(Collections.max(this.temps).clone());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<TemperatureMeasurement> getMin() {
        if (this.getCount() > 0) {
            return Optional.of(Collections.min(this.temps).clone());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<TemperatureMeasurement> getAverage() {
        if (this.temps.isEmpty()) {
            return Optional.empty();
        }

        double tempSum = 0.0;
        for (final TemperatureMeasurement t : this.temps) {
            tempSum += t.measurement().getCelsius();
        }
        float average = (float) (tempSum / this.temps.size());

        return Optional.of(new TemperatureMeasurement(null, Temperature.fromCelsius(average)));
    }

    public void addTemperatureEventListener(TemperatureEventListener listener) {
        if (null != listener)
            this.listeners.add(listener);
    }

    public void removeTemperatureEventListener(TemperatureEventListener listener) {
        if (null != listener)
            this.listeners.remove(listener);
    }

    public void fireTemperatureEvent(TemperatureEvent evt) {
        for (final TemperatureEventListener listener :
                this.listeners) {
            listener.temperatureExtremaChanged(evt);
        }
    }

    private void testTemperatureExtrema(TemperatureMeasurement temp) {
        if (null == temp) {
            return;
        }

        if (null == this.minTemp || temp.compareTo(this.minTemp) < 0) {
            this.minTemp = temp;
            fireTemperatureEvent(new TemperatureEvent(
                    this,
                    TemperatureEventType.MIN,
                    new Temperature(this.minTemp.measurement())
            ));
        }

        if (null == this.maxTemp || temp.compareTo(this.maxTemp) > 0) {
            this.maxTemp = temp;
            fireTemperatureEvent(new TemperatureEvent(
                    this,
                    TemperatureEventType.MAX,
                    new Temperature(this.maxTemp.measurement())
            ));
        }
    }

}
