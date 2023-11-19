package ch.hslu.oop.sw8;

import java.awt.*;

public enum AggregateState {

    LIQUID("flüssig"),
    SOLID("fest"),
    GASEOUS("gasförmig"),
    PLASMA("plasma");
    private final String bezeichnung;
    private AggregateState(String bezeichnung){
        this.bezeichnung = bezeichnung;
    }
    @Override
    public final String toString(){
        return this.bezeichnung;
    }
}
