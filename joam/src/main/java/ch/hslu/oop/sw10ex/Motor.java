package ch.hslu.oop.sw10ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public final class Motor implements Switchable {

    private ComponentState motorState = ComponentState.OFF;
    private int rpm = 0;

    private final List<PropertyChangeListener> listeners = new ArrayList<>();

    private static final int SPEEDUP_INTERVAL_RPM = 100;

    private static final Logger LOG = LoggerFactory.getLogger(Motor.class);

    public Motor() {
    }

    public Motor(PropertyChangeListener motorPropertyChangeListener) {
        this.addPropertyChangeListener(motorPropertyChangeListener);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if (listener != null)
            this.listeners.add(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        if (listener != null)
            this.listeners.remove(listener);
    }

    private void firePropertyChangeEvent(PropertyChangeEvent e) {
        for (final PropertyChangeListener listener :
                this.listeners) {
            listener.propertyChange(e);
        }
    }

    @Override
    public void switchOn() {
        LOG.info("Turing Motor on...");

        firePropertyChangeEvent(
                new PropertyChangeEvent(this, "motorState", this.motorState, ComponentState.ON)
        );
        this.motorState = ComponentState.ON;
    }

    @Override
    public void switchOff() {
        LOG.info("Turning motor off and resetting rpm to 0.");

        firePropertyChangeEvent(
                new PropertyChangeEvent(this, "motorState", this.motorState, ComponentState.OFF)
        );
        firePropertyChangeEvent(
                new PropertyChangeEvent(this, "motorRpm", this.rpm, 0)
        );

        this.motorState = ComponentState.OFF;
        this.rpm = 0;
    }

    @Override
    public boolean isSwitchedOn() {
        return this.motorState.equals(ComponentState.ON);
    }

    @Override
    public boolean isSwitchedOff() {
        return this.motorState.equals(ComponentState.OFF);
    }

    public final int getRpm() {
        return this.rpm;
    }

    public final void speedUp() {
        final int oldRpm = this.rpm;
        this.rpm += Motor.SPEEDUP_INTERVAL_RPM;

        firePropertyChangeEvent(
                new PropertyChangeEvent(this, "motorRpm", oldRpm, this.rpm)
        );
    }

    public final void slowDown() {
        final int oldRpm = this.rpm;
        this.rpm -= ((this.rpm >= SPEEDUP_INTERVAL_RPM) ? 1 : 0) * Motor.SPEEDUP_INTERVAL_RPM;

        if (oldRpm != this.rpm) {
            firePropertyChangeEvent(
                    new PropertyChangeEvent(this, "motorRpm", oldRpm, this.rpm)
            );
        }
    }

}