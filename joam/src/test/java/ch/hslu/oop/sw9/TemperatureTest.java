package ch.hslu.oop.sw9;

import ch.hslu.oop.sw8.Temperature;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureTest {

	@Test
	public void testTemperaturEqualsContract() {
		EqualsVerifier.forClass(ch.hslu.oop.sw8.Temperature.class)
		.suppress(Warning.NONFINAL_FIELDS)
		.verify();
	}

	@Test
	public void testTempartureCompareToEquals() {
		ch.hslu.oop.sw8.Temperature t1 = new ch.hslu.oop.sw8.Temperature(35);
		ch.hslu.oop.sw8.Temperature t2 = new ch.hslu.oop.sw8.Temperature(35);

		assertEquals(0, t1.compareTo(t2));
	}

	@Test
	public void testTempartureCompareToGreater() {
		ch.hslu.oop.sw8.Temperature t1 = new ch.hslu.oop.sw8.Temperature(-3);
		ch.hslu.oop.sw8.Temperature t2 = new ch.hslu.oop.sw8.Temperature(35);

		assertTrue(t1.compareTo(t2) < 0);
		assertTrue(t2.compareTo(t1) > 0);
	}

	@Test
	public void testTempartureSetKelvin() {
		ch.hslu.oop.sw8.Temperature t1 = new ch.hslu.oop.sw8.Temperature(15f);
		t1.setKelvin(0f);

		assertEquals(0, Float.compare(t1.getCelsius(), -273.15f));
	}

	@Test
	public void testTempartureConvertCelsiusToKelvin() {
		assertEquals(273.15f, ch.hslu.oop.sw8.Temperature.convertCelsiusToKelvin(0));
	}

	@Test
	public void testTempartureConvertKelvinToCelsius() {
		assertEquals(-273.15f, ch.hslu.oop.sw8.Temperature.convertKelvinToCelsius(0));
	}

	@Test
	public void testTempartureSetCelsius() {
		ch.hslu.oop.sw8.Temperature t1 = new Temperature(15f);
		t1.setCelsius(0f);

		assertEquals(0, Float.compare(t1.getCelsius(), 0f));
	}

	@Test
	public void testTemperatureIllegalArgument(){
		final Exception e =
				assertThrows(IllegalArgumentException.class, () -> {
					new ch.hslu.oop.sw9.Temperature(-273.151f);
				});
	}

}
