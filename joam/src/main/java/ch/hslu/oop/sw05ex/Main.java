/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ch.hslu.oop.sw05ex;

/**
 *
 * @author Joël Ammann
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Square mySquare = new Square(10, 20, 10);

        System.out.println(mySquare.getArea());

        Element Hydrogen = new HydrogenElement();
        System.out.println(Hydrogen.getAggregateState(0f));


        System.out.println("creating a new Motor and switching it on/off 5 times...");

        Motor myMotor = new Motor();
        myMotor.switchOn();
        myMotor.switchOff();
        myMotor.switchOn();
        myMotor.switchOff();
        myMotor.switchOn();

        System.out.println("switch count: " + myMotor.getSwitchCount());

    }
}