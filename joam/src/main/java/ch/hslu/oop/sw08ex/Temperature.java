/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.hslu.oop.sw08ex;

import java.util.Objects;

/**
 *
 * @author Joël Ammann
 */
public final class Temperature implements Comparable<Temperature> {
    
    private float celsius;
    public static final float KELVIN_OFFSET = 273.15f;

    /**
     * Creates a new temperature object with given celsius value.
     * @param celsius
     */
    public Temperature(float celsius) {
        this.celsius = celsius;
    }

    /**
     * Returns the current temperature in celsius.
     * @return temperature in celsius
     */
    public float getCelsius() {
        return this.celsius;
    }

    /**
     * Returns the current temperature in kelvin.
     * @return temperature in kelvin
     */
    public float getKelvin(){
        return Temperature.convertCelsiusToKelvin(this.celsius);
    }
    
    /**
     * Sets the current temperature to the given value
     * @param celsius temperature in celsius
     */
    public void setCelsius(float celsius) {
        this.celsius = celsius;
    }

    /**
     * Sets the current temperature to the given value
     * @param celsius temperature in celsius
     */
    public void setKelvin(float kelvin) {
        this.celsius = Temperature.convertKelvinToCelsius(kelvin);
    }

    /**
     * Converts given celsius value to kelvin.
     * @param celsius
     * @return temperature in kelvin.
     */
    public static float convertCelsiusToKelvin(float celsius){
        return celsius + Temperature.KELVIN_OFFSET;
    }
    
    /**
     * Converts given kelvin value to celsius.
     * @param celsius
     * @return temperature in celsius.
     */
    public static float convertKelvinToCelsius(float kelvin){
        return kelvin - Temperature.KELVIN_OFFSET;
    }

    /**
     * Prints the toString method's output
     */
    public void printDebug()
    {
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        return String.format("Temperature[celsius=%s]", this.celsius);
    }

    @Override
    public final boolean equals(Object object) {
        if(object == this){
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
}
