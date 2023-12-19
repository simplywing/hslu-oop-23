package ch.hslu.oop.sw04ex;

public class Wiper implements Switchable {

    private boolean isSwitchedOn = false;

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
    
}
