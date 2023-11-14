package ch.hslu.oop.sw5;

public class Motor implements CountingSwitchable, Named {

    private boolean isSwitchedOn = false;
    private int rpm;
    private long switchCount = 0;

    private String name = "The super motor";

    public Motor() {
        this.rpm = 0;
    }

    @Override
    public void switchOn() {
        this.switchCount++;
        this.isSwitchedOn = true;
    }

    @Override
    public void switchOff() {
        this.switchCount++;
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

    @Override
    public final long getSwitchCount() {
        return this.switchCount;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final void setName(final String name) {
        this.name = name;
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
