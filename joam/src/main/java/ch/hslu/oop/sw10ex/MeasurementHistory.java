package ch.hslu.oop.sw10ex;

import java.util.Optional;

/**
 * Interface for measurement series of generic type.
 * @param <T> Type of object being stored in the measurement series.
 */
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
     * Returns the amount of measurement values stored at this time.
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
