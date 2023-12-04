/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.hslu.oop.sw7;

import java.util.Objects;

/**
 *
 * @author Joël Ammann
 */
public class Temperature implements Comparable<Temperature> {
    private float celsius;

    public Temperature(float celsius) {
        this.celsius = celsius;
    }

    public float getCelsius() {
        return this.celsius;
    }
    
    public void setCelsius(float celsius) {
        this.celsius = celsius;
    }

    private AggregateState getAggregateStateByElementProperties(final float meltingPoint, final float boilingPoint)
    {
        if(this.celsius <= meltingPoint){
            return AggregateState.SOLID;
        } else if (this.celsius > meltingPoint && this.celsius < boilingPoint){
            return AggregateState.LIQUID;
        } else {
            return AggregateState.GASEOUS;
        }
    }

    public AggregateState getAggregateState(String element)
    {
        AggregateState aggregateState = switch (element){
            case "N":
                yield getAggregateStateByElementProperties(-209.86f, -195.79f);

            case "Hg":
                yield getAggregateStateByElementProperties(-38.9f, 356.7f);

            case "Pb":
                yield getAggregateStateByElementProperties(327f, 1755f);

            /* By default, assume H2O */
            default:
                yield getAggregateStateByElementProperties(0f, 100f);
        };

        return aggregateState;
    }

    public void printDebug()
    {
        System.out.println("Temperature Object -> celsius: " + this.celsius);
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
