package ch.hslu.oop.sw4;

public class Motor implements Switchable {

    private boolean isSwitchedOn = false;
    private int rpm;

    public Motor() {
        this.rpm = 0;
    }

    @Override
    public void switchOn() {
        this.isSwitchedOn = true;
    }

    @Override
    public void switchOff() {
        this.isSwitchedOn = false;
    }

    @Override
    public boolean isSwitchedOn() {
        return this.isSwitchedOn;
    }

    @Override
    public boolean isSwitchedOff() {
        return !this.isSwitchedOn;
    }

    public final int getRpm() {
        return this.rpm;
    }
    
    public final void speedUp() {
        this.rpm += 100;
    }
    
    public final void slowDown() {
        this.rpm -= 100;
    }
    
}
