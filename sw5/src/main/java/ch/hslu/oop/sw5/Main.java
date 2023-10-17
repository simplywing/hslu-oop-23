/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ch.hslu.oop.sw5;

/**
 *
 * @author Joël Ammann
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Rectangle mySquare = new Square(10, 20, 10);

        System.out.println(mySquare.getArea());

        Element Hydrogen = new HydrogenElement();
        System.out.println(Hydrogen.getAggregateState(0f));

    }
}