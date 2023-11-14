/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.hslu.oop.sw2;

/**
 *
 * @author Joël Ammann
 */
public class Temperatur {

    private float ambientTemperatureCelsius = 20f;

    public Temperatur() {
    }

    public Temperatur(float celsius) {
        this.ambientTemperatureCelsius = celsius;
    }

    /**
     * Get the ambient temperature in celcius
     * @return current ambient temperature in celcius
     */
    public float getAmbientTemperatureCelsius() {
        return this.ambientTemperatureCelsius;
    }

    /**
     * Get the ambient temperature in kelvin
     * @return current ambient temperature in kelvin
     */
    public float getAmbientTemperatureKelvin() {
        return this.ambientTemperatureCelsius + 273.15f;
    }

    /**
     * Get the ambient temperature in farenheit
     * @return current ambient temperature in farenheit
     */
    public float getAmbientTemperatureFarenheit() {
        return (this.ambientTemperatureCelsius * 1.8f + 32f);
    }

    /**
     * Set the ambient temperature to a specific value in celcius
     * @param celsius the new ambient temperature in celcius
     */
    public void setAmbientTemperatureCelsius(float celsius) {
        this.ambientTemperatureCelsius = celsius;
    }

    /**
     * Change the ambient temperature by specifying the change value (delta)
     * @param delta the change value in celcius or kelvin
     */
    public void addAmbientTemperatureCelsius(float delta) {
        this.ambientTemperatureCelsius += delta;
    }

    /**
     * Print the current ambient temperature in all units
     */
    public void printDebugInfo() {
        System.out.println("Die aktuelle Temperatur (C) ist: " + this.getAmbientTemperatureCelsius());
        System.out.println("Die aktuelle Temperatur (F) ist: " + this.getAmbientTemperatureFarenheit());
        System.out.println("Die aktuelle Temperatur (K) ist: " + this.getAmbientTemperatureKelvin());
    }

}
