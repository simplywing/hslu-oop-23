package ch.hslu.oop.sw4;

public class Car implements Switchable {

    private boolean isSwitchedOn = false;
    
    private Motor motor;
    private Wiper wiper;

    public Car(){
        this.motor = new Motor();
        this.wiper = new Wiper();
    }

    @Override
    public void switchOn() {
        this.motor.switchOn();
        this.wiper.switchOn();
        
        this.isSwitchedOn = true;
    }

    @Override
    public void switchOff() {
        this.motor.switchOff();
        this.wiper.switchOff();

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
