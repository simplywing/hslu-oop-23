package ch.hslu.oop.sw8;

import java.util.Optional;

public interface MeasurementHistory<T> {
    /**
     * Method to add a new measurement value.
     * @param obj measurement object.
     */
    public void add(T obj);

    /**
     * Remove all stored measurement values.
     */
    public void clear();

    /**
     * Returns the ammount of measurement values stored at this time.
     * @return The count of all measurement values.
     */
    public int getCount();

    /**
     * Returns the maximum measurement value.
     * @return the maximum measurement value in celsius.
     */
    public Optional<T> getMax();

    /**
     * Returns the minimum measurement value.
     * @return the minimum measurement value in celsius.
     */
    public Optional<T> getMin();

    /**
     * Returns the average measurement as a new Object.
     * This method returns an empty Optional, if no measurements are present.
     * @return Average measurement Value
     */
    public Optional<T> getAverage();

}
