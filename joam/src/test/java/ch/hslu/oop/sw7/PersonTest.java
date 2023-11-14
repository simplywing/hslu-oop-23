/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ch.hslu.oop.sw7;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author JoëlAmmann
 */
public class PersonTest {
    
    @Test
    public void testPersonCreate() {
        Person p = Person.create(1234, "Reiner", "Zufall");

        assertEquals(1234, p.getId());
        assertEquals("Reiner", p.getFirstname());
        assertEquals("Zufall", p.getLastname());
    }

    @Test
    public void testPersonEqualContract() {
        EqualsVerifier.forClass(Person.class)
        .withIgnoredFields("firstname", "lastname")
        .verify();
    }

    @Test
    public void testPersonEqualsTrue() {
        Person p1 = Person.create(1234, "Reiner", "Zufall");
        Person p2 = p1;

        assertEquals(true, p1.equals(p2));
    }

    @Test
    public void testPersonEqualsFalse() {
        Person p1 = Person.create(1234, "Reiner", "Zufall");
        Person p2 = Person.create(2344, "Reiner", "Zufall");

        assertEquals(false, p1.equals(p2));
    }

    @Test
    public void testPersonEqualsNull() {
        Person p1 = Person.create(1234, "Reiner", "Zufall");

        assertEquals(false, p1.equals(null));
    }
    
}
