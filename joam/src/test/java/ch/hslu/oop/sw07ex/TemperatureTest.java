package ch.hslu.oop.sw07ex;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureTest {

	@Test
	public void testTemperaturEqualsContract() {
		EqualsVerifier.forClass(Temperature.class)
		.suppress(Warning.NONFINAL_FIELDS)
		.verify();
	}

	@Test
	public void testTempartureCompareToEquals() {
		Temperature t1 = new Temperature(35);
		Temperature t2 = new Temperature(35);

		assertEquals(0, t1.compareTo(t2));
	}

	@Test
	public void testTempartureCompareToGreater() {
		Temperature t1 = new Temperature(-3);
		Temperature t2 = new Temperature(35);

		assertTrue(t1.compareTo(t2) < 0);
		assertTrue(t2.compareTo(t1) > 0);
	}

}
