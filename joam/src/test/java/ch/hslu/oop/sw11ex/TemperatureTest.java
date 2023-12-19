package ch.hslu.oop.sw11ex;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureTest {

	@Test
	public void testTemperatureEqualsContract() {
		EqualsVerifier.forClass(Temperature.class)
		.suppress(Warning.NONFINAL_FIELDS)
		.verify();
	}

	@Test
	public void testTemperatureCompareToEquals() {
		Temperature t1 = new Temperature(35);
		Temperature t2 = new Temperature(35);

		assertEquals(0, t1.compareTo(t2));
	}

	@Test
	public void testTemperatureCompareToGreater() {
		Temperature t1 = new Temperature(-3);
		Temperature t2 = new Temperature(35);

		assertTrue(t1.compareTo(t2) < 0);
		assertTrue(t2.compareTo(t1) > 0);
	}

	@Test
	public void testTemperatureConvertCelsiusToKelvin() {
		assertEquals(273.15f, Temperature.convertCelsiusToKelvin(0));
	}

	@Test
	public void testTemperatureConvertKelvinToCelsius() {
		assertEquals(-273.15f, Temperature.convertKelvinToCelsius(0));
	}

	@Test
	public void testTemperatureIllegalArgument(){
		final Exception e =
				assertThrows(IllegalArgumentException.class, () -> {
					new Temperature(-273.151f);
				});
	}

}
