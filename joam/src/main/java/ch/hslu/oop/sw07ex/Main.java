/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ch.hslu.oop.sw07ex;

/**
 *
 * @author JoëlAmmann
 */
public class Main {

    public static void main(String[] args) {

        Person myPerson = Person.create(324234, "Joël", "Ammann");
        System.out.println(myPerson.toString());
    }
}
