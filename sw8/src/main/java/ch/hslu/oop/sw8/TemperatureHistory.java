package ch.hslu.oop.sw8;

import java.util.Optional;

public interface TemperatureHistory {
    /**
     * Method to add a new temperature value.
     * @param temp temperature in celsius
     */
    public void add(Temperature temp);

    /**
     * Remove all stored temperature values.
     */
    public void clear();

    /**
     * Returns the ammount of temperature values stored at this time.
     * @return The count of all temperature values.
     */
    public int getCount();

    /**
     * Returns the maximum temperature value.
     * @return the maximum temperature value in celsius.
     */
    public Temperature getMax();

    /**
     * Returns the minimum temperature value.
     * @return the minimum temperature value in celsius.
     */
    public Temperature getMin();

    /**
     * Returns the average Temperature as a new Temperature Object.
     * This method returns an empty Optional, if no temperatures are present.
     * @return Average Temperature Value
     */
    public Optional<Temperature> getAverage();

}
