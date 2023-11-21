package ch.hslu.oop.sw10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testSwitchOn() {
        var myCar = new Car();
        myCar.switchOn();
        assertFalse(myCar.isSwitchedOff());
        assertTrue(myCar.isSwitchedOn());
    }

    @Test
    void switchOff() {
        var myCar = new Car();
        myCar.switchOn();
        myCar.switchOff();
        assertFalse(myCar.isSwitchedOn());
        assertTrue(myCar.isSwitchedOff());
    }

    @Test
    void isSwitchedOn() {
        assertFalse((new Car()).isSwitchedOn());
    }

    @Test
    void isSwitchedOff() {
        assertTrue((new Car()).isSwitchedOff());
    }
}