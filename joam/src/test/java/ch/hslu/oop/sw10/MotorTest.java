package ch.hslu.oop.sw10;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

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

            /* Proof that outer class attributes can be shadowed, see below :) */
            private boolean callbackWasCalled;
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

                /* Because callbackWasCalled is shadowed in the inner class, we have to access the outer
                * Class by using the ClassName.this.property syntax
                * otherwise we could use callbackWasCalled directly */
                MotorTest.this.callbackWasCalled = true;

                assertEquals("motorState", evt.getPropertyName());
                assertEquals(ComponentState.ON, evt.getNewValue());
            }
        });

        myMotor.switchOn();
        assertTrue(this.callbackWasCalled);
    }

    @Test
    void addPropertyChangeListenerMotorStateAlternative() {
        var myMotor = new Motor();
        AtomicBoolean callbackWasCalled = new AtomicBoolean(false);
        myMotor.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                callbackWasCalled.set(true);
                assertEquals("motorState", evt.getPropertyName());
                assertEquals(ComponentState.ON, evt.getNewValue());
            }
        });

        myMotor.switchOn();
        assertTrue(callbackWasCalled.getPlain());
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
    void addPropertyChangeListenerMotorStateLambdaWithAtomicBool() {
        var myMotor = new Motor();

        /* Besten Dank an Frau Junghans für die Idee mit dem AtomicBoolean :) */
        AtomicBoolean callbackWasCalledAtomic = new AtomicBoolean(false);

        /* Instead of an AtomicBoolean we cloud use any effectively final type */
        List<Boolean> thisIsJustaTest = new ArrayList<>();

        myMotor.addPropertyChangeListener(
                evt -> {
                    callbackWasCalledAtomic.set(true);
                    thisIsJustaTest.add(Boolean.TRUE);

                    assertEquals("motorState", evt.getPropertyName());
                    assertEquals(ComponentState.ON, evt.getNewValue());
                }
        );

        myMotor.switchOn();
        assertTrue(callbackWasCalledAtomic.getPlain());
        assertTrue(thisIsJustaTest.get(0));
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