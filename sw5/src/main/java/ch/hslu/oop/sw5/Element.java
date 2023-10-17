package ch.hslu.oop.sw5;

import java.time.LocalDate;

public abstract class Element {
    private float atomicMassU, meltingPointKelvin, boilingPointKelvin;
    private int discoveryDate;

    public Element(float atomicMassU, float meltingPointKelvin, float boilingPointKelvin, int discoveryDate) {
        this.atomicMassU = atomicMassU;
        this.meltingPointKelvin = meltingPointKelvin;
        this.boilingPointKelvin = boilingPointKelvin;
        this.discoveryDate = discoveryDate;
    }

    public final AggregateState getAggregateState(float temperatureKelvin) {
        if(temperatureKelvin <= this.meltingPointKelvin){
            return AggregateState.SOLID;
        } else if (temperatureKelvin > this.boilingPointKelvin && temperatureKelvin < this.boilingPointKelvin){
            return AggregateState.LIQUID;
        } else {
            return AggregateState.GASEOUS;
        }
    }

    public static final AggregateState getAggregateState(float temperatureKelvin, float meltingPointKelvin, float boilingPointKelvin) {
        if(temperatureKelvin <= meltingPointKelvin){
            return AggregateState.SOLID;
        } else if (temperatureKelvin > boilingPointKelvin && temperatureKelvin < boilingPointKelvin){
            return AggregateState.LIQUID;
        } else {
            return AggregateState.GASEOUS;
        }
    }

}
