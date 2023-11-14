package ch.hslu.oop.sw6;

public interface ICalculator {
    /**
     * Adds two double summands together and returns the sum.
     * @param summand1 The first summand.
     * @param summand2 The second summand.
     * @return the sum of both summands.
     */
    double addition(double summand1, double summand2);

    /**
     * Adds two long summands together and returns the sum.
     * @param summand1 The first summand.
     * @param summand2 The second summand.
     * @return the sum of both summands.
     */
    long addition(long summand1, long summand2);
}
