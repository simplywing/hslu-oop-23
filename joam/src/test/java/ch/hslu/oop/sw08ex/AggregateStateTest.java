package ch.hslu.oop.sw08ex;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AggregateStateTest {
    @Test
    public void testToStringLiquid() {
        AggregateState test = AggregateState.LIQUID;
        assertEquals("flüssig", test.toString());
    }

    @Test
    public void testToStringSolid() {
        AggregateState test = AggregateState.SOLID;
        assertEquals("fest", test.toString());
    }

    @Test
    public void testToStringGaseous() {
        AggregateState test = AggregateState.GASEOUS;
        assertEquals("gasförmig", test.toString());
    }

    @Test
    public void testToStringPlasma() {
        AggregateState test = AggregateState.PLASMA;
        assertEquals("plasma", test.toString());
    }
}