package ch.hslu.oop.sw05ex;

/**
 * Interface for switchable objects.
 */
public interface Switchable {
    /**
     * Switches the object on.
     */
    void switchOn();

    /**
     * Switches the object off.
     */
    void switchOff();

    /**
     * Checks if the object is switched on.
     * 
     * @return true if the object is switched on, otherwise false.
     */
    boolean isSwitchedOn();

    /**
     * Checks if the object is switched off.
     * 
     * @return true if the object is switched off, otherwise false.
     */
    boolean isSwitchedOff();
}
