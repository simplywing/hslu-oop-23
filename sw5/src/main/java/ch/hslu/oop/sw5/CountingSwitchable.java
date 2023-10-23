package ch.hslu.oop.sw5;

/**
 * Interface for switchable objects that return the switch count.
 */
public interface CountingSwitchable extends Switchable {
 
    /**
     * Returns the number of time the object has switched state (on/off).
     * @return 
     */
    long getSwitchCount();

}
