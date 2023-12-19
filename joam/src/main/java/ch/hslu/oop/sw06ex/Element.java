package ch.hslu.oop.sw06ex;

public abstract class Element {
    private float atomicMassU, meltingPointKelvin, boilingPointKelvin;
    private int discoveryDate;

    public Element(float atomicMassU, float meltingPointKelvin, float boilingPointKelvin, int discoveryDate) {
        this.atomicMassU = atomicMassU;
        this.meltingPointKelvin = meltingPointKelvin;
        this.boilingPointKelvin = boilingPointKelvin;
        this.discoveryDate = discoveryDate;
    }

    /**
     * get Aggregate State of Element
     * @param temperatureKelvin
     * @return AggregateState Enum
     */
    public final AggregateState getAggregateState(float temperatureKelvin) {
        return Element.getAggregateStateFromParam(temperatureKelvin, this.meltingPointKelvin, this.boilingPointKelvin);
    }

    /**
     * get Aggregate State of Element with specified properties
     * @param temperatureKelvin
     * @param meltingPointKelvin
     * @param boilingPointKelvin
     * @return AggregateState Enum
     */
    public static final AggregateState getAggregateState(float temperatureKelvin, float meltingPointKelvin, float boilingPointKelvin) {
        return Element.getAggregateStateFromParam(temperatureKelvin, meltingPointKelvin, boilingPointKelvin);
    }

    /**
     * internal method to get Aggregate State of Element with specified properties
     * @param temperatureKelvin
     * @param meltingPointKelvin
     * @param boilingPointKelvin
     * @return AggregateState Enum
     */
    private static final AggregateState getAggregateStateFromParam(float temperatureKelvin, float meltingPointKelvin, float boilingPointKelvin){
        if(temperatureKelvin <= meltingPointKelvin){
            return AggregateState.SOLID;
        } else if (temperatureKelvin > boilingPointKelvin && temperatureKelvin < boilingPointKelvin){
            return AggregateState.LIQUID;
        } else {
            return AggregateState.GASEOUS;
        }
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[" +
                "atomicMassU=" + this.atomicMassU +
                ", meltingPointKelvin=" + this.meltingPointKelvin +
                ", boilingPointKelvin=" + this.boilingPointKelvin +
                ", discoveryDate=" + this.discoveryDate +
                ']';
    }

}
