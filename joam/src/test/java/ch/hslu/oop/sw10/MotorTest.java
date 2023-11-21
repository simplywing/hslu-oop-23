package ch.hslu.oop.sw10;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;

class MotorTest {

    private boolean callbackWasCalled;

    @Test
    void switchOn() {
        var myMotor = new Motor();
        myMotor.switchOn();
        assertTrue(myMotor.isSwitchedOn());
        assertFalse(myMotor.isSwitchedOff());
    }

    @Test
    void switchOff() {
        var myMotor = new Motor();
        myMotor.switchOff();
        assertTrue(myMotor.isSwitchedOff());
        assertFalse(myMotor.isSwitchedOn());
    }

    @Test
    void isSwitchedOn() {
        assertFalse((new Motor()).isSwitchedOn());
    }

    @Test
    void isSwitchedOff() {
        assertTrue((new Motor()).isSwitchedOff());
    }

    @Disabled
    @Test
    void getRpm() {
    }

    @Test
    void speedUp() {
        var myMotor = new Motor();
        final int oldRpm = myMotor.getRpm();
        myMotor.speedUp();

        assertTrue(oldRpm < myMotor.getRpm());
    }

    @Test
    void slowDown() {
        var myMotor = new Motor();
        myMotor.speedUp();

        final int oldRpm = myMotor.getRpm();
        myMotor.slowDown();
        assertTrue(oldRpm > myMotor.getRpm());
    }

    @Test
    void addPropertyChangeListenerMotorState() {
        this.callbackWasCalled = false;
        var myMotor = new Motor();
        myMotor.addPropertyChangeListener(new PropertyChangeListener() {

            /* Proof that outer class attributes can be shadowed :) */
            private boolean callbackWasCalled;
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                MotorTest.this.callbackWasCalled = true;
                assertEquals("motorState", evt.getPropertyName());
                assertEquals(ComponentState.ON, evt.getNewValue());
            }
        });

        myMotor.switchOn();
        assertTrue(this.callbackWasCalled);
    }

    @Test
    void addPropertyChangeListenerMotorStateLambda() {
        this.callbackWasCalled = false;

        var myMotor = new Motor();
        myMotor.addPropertyChangeListener(
                evt -> {
                    MotorTest.this.callbackWasCalled = true;
                    assertEquals("motorState", evt.getPropertyName());
                    assertEquals(ComponentState.ON, evt.getNewValue());
                }
        );

        myMotor.switchOn();
        assertTrue(this.callbackWasCalled);
    }

    @Test
    void addPropertyChangeListenerMotorRpm() {
        this.callbackWasCalled = false;
        var myMotor = new Motor();
        myMotor.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                MotorTest.this.callbackWasCalled = true;
                assertEquals("motorRpm", evt.getPropertyName());
            }
        });

        myMotor.speedUp();
        assertTrue(this.callbackWasCalled);
    }

    @Test
    void removePropertyChangeListener() {
    }
}