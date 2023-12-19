package ch.hslu.oop.sw10ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Car implements Switchable {

    private ComponentState carState = ComponentState.OFF;
    private final Motor motor;
    private final Wiper wiper;

    /**
     * List containing references to all Switchable components of the Car.
     * It is assumed that every component added to this List must be switched on when the car is switched on.
     */
    private final List<Switchable> switchableComponents = new ArrayList<>();

    private static final Logger LOG = LoggerFactory.getLogger(Car.class);

    private class MotorPropertyChangeListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent e) {
            Car.this.handleMotorEvents(e);
        }
    }

    public Car() {
        this.motor = new Motor(new Car.MotorPropertyChangeListener());
        this.wiper = new Wiper();

        this.switchableComponents.add(this.motor);
        this.switchableComponents.add(this.wiper);
    }

    public void speedUp() {
        this.motor.speedUp();
    }

    public void slowDown() {
        this.motor.slowDown();
    }

    @Override
    public void switchOn() {
        for (final Switchable component : this.switchableComponents) {
            component.switchOn();
        }

        this.carState = ComponentState.ON;
    }

    @Override
    public void switchOff() {
        for (final Switchable component : this.switchableComponents) {
            component.switchOff();
        }

        this.carState = ComponentState.OFF;
    }

    @Override
    public boolean isSwitchedOn() {
        return (this.carState.equals(ComponentState.ON));
    }

    @Override
    public boolean isSwitchedOff() {
        return (this.carState.equals(ComponentState.OFF));
    }

    private void handleMotorEvents(PropertyChangeEvent evt) {
        LOG.debug("Car received an Event from the Motor!");
        if (evt.getPropertyName().equals("motorRpm")) {
            LOG.info(String.format(
                    "Event: The motor RPM changed from [%s] to [%s]",
                    evt.getOldValue().toString(),
                    evt.getNewValue().toString()
            ));
        } else if (evt.getPropertyName().equals("motorState")) {
            LOG.info(String.format("Event: New state of the motor: %s", evt.getNewValue().toString()));
        }
    }

}
