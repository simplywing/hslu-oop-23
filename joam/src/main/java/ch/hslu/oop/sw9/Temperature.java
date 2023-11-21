package ch.hslu.oop.sw9;

import java.util.Objects;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * @author Joël Ammann
 */
public final class Temperature implements Comparable<Temperature> {
    private final float celsius;
    public static final float KELVIN_OFFSET = 273.15f;
    private static final float CELSIUS_LOWERLIMIT = -KELVIN_OFFSET;

    private static final Logger LOG = LoggerFactory.getLogger(Temperature.class);

    /**
     * Creates a new temperature object with given Celsius value.
     *
     * @param celsius value in celsius.
     */
    public Temperature(float celsius) {
        this.celsius = validateCelsius(celsius);
    }

    /**
     * Creates a new temperature object from a given temperature object.
     * @param temperature temperature object to copy
     */
    public Temperature(Temperature temperature) {
        this.celsius = temperature.celsius;
    }

    /**
     * Creates a new temperature object with give kelvin value.
     * @param kelvin temperature in kelvin.
     * @return temperature object
     */
    public static Temperature fromKelvin(float kelvin) {
        return new Temperature(validateCelsius(convertKelvinToCelsius(kelvin)));
    }

    /**
     * Creates a new temperature object with give Celsius value.
     * @param celsius temperature in celsius
     * @return temperature object
     */
    public static Temperature fromCelsius(float celsius) {
        return new Temperature(validateCelsius(celsius));
    }

    /**
     * Returns the current temperature in Celsius.
     * @return temperature in celsius
     */
    public float getCelsius() {
        return this.celsius;
    }

    /**
     * Returns the current temperature in kelvin.
     *
     * @return temperature in kelvin
     */
    public float getKelvin() {
        return Temperature.convertCelsiusToKelvin(this.celsius);
    }

    /**
     * Converts given celsius value to kelvin.
     *
     * @param celsius value in celsius.
     * @return temperature in kelvin.
     */
    public static float convertCelsiusToKelvin(float celsius) {
        return celsius + Temperature.KELVIN_OFFSET;
    }

    /**
     * Converts given kelvin value to celsius.
     *
     * @param kelvin value in kelvin.
     * @return temperature in celsius.
     */
    public static float convertKelvinToCelsius(float kelvin) {
        return kelvin - Temperature.KELVIN_OFFSET;
    }

    /**
     * Prints the toString method's output
     */
    public void printDebug() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("Temperature[celsius=%s]", this.celsius);
    }

    @Override
    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Temperature t)
                && (Float.compare(this.celsius, t.celsius) == 0);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.celsius);
    }

    @Override
    public final int compareTo(Temperature other) {
        return Float.compare(this.celsius, other.celsius);
    }

    private static float validateCelsius(float celsius) {
        if(celsius < Temperature.CELSIUS_LOWERLIMIT){
            LOG.error(String.format("Illegal temperature: [%s]", celsius));
            throw new IllegalArgumentException("Temperature cannot be lower than 0 Kelvin or -273.15 Celsius.");
        }
        else {
            return celsius;
        }
    }
}
