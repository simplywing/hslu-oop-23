/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.hslu.oop.sw7;

import java.util.Objects;

/**
 *
 * @author JoëlAmmann
 */
public class Person implements Comparable<Person>{

    private final long id;
    private String firstname;
    private String lastname;

    private Person(long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public static Person create(long id, String firstname, String lastname) {
        return new Person(id, firstname, lastname);
    }

    public final long getId() {
        return this.id;
    }

    public final String getFirstname() {
        return this.firstname;
    }

    public final String getLastname() {
        return this.lastname;
    }

    public final void setFirstname(String newFirstname) {
        this.firstname = newFirstname;
    }

    public final void setLastname(String newLastname) {
        this.lastname = newLastname;
    }

    @Override
    public String toString() {
        return String.format("Person[id=%s, firstname=%s, lastname=%s]", this.id, this.firstname, this.lastname);
    }

    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Person p)
                && (this.id == p.id);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public final int compareTo(Person other) {
        return Long.compare(this.id, other.id);
    }



}
