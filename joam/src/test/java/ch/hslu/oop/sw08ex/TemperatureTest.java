package ch.hslu.oop.sw08ex;

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

	@Test
	public void testTempartureSetKelvin() {
		Temperature t1 = new Temperature(15f);
		t1.setKelvin(0f);

		assertEquals(0, Float.compare(t1.getCelsius(), -273.15f));
	}

	@Test
	public void testTempartureConvertCelsiusToKelvin() {
		assertEquals(273.15f, Temperature.convertCelsiusToKelvin(0));
	}

	@Test
	public void testTempartureConvertKelvinToCelsius() {
		assertEquals(-273.15f, Temperature.convertKelvinToCelsius(0));
	}

	@Test
	public void testTempartureSetCelsius() {
		Temperature t1 = new Temperature(15f);
		t1.setCelsius(0f);

		assertEquals(0, Float.compare(t1.getCelsius(), 0f));
	}

}
