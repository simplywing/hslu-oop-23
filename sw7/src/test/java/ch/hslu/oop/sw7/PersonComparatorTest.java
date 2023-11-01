package ch.hslu.oop.sw7;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import static org.junit.jupiter.api.Assertions.*;

public class PersonComparatorTest {

	@Test
	public void testPersonComparatorCompareEqual() {
		PersonComparator comparator = new PersonComparator();
		Person first = Person.create(1321, "Steve", "Beck");
		Person second = Person.create(4233, "Steve", "Beck");

		assertEquals(0, comparator.compare(first, second));
	}

	@Test
	public void testPersonComparatorCompareDifferentFirstname() {
		PersonComparator comparator = new PersonComparator();
		Person first = Person.create(5676, "Steve", "Beck");
		Person second = Person.create(3457, "Peter", "Beck");

		assertTrue(0 < comparator.compare(first, second));
	}

	@Test
	public void testPersonComparatorCompareDifferentLastname() {
		PersonComparator comparator = new PersonComparator();
		Person first = Person.create(5676, "Steve", "Aborn");
		Person second = Person.create(3457, "Peter", "Beck");

		assertTrue(0 > comparator.compare(first, second));
	}

	@Test
	public void testPersonComparatorEqualContract() {
		EqualsVerifier.forClass(PersonComparator.class)
		.verify();
	}

}
