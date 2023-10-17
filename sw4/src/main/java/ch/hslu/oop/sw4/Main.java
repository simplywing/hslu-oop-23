/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ch.hslu.oop.sw4;

/**
 *
 * @author Joël Ammann
 */
public class Main {

    public static void main(String[] args) {
        
        System.out.println("Creating a new Car...");
        Car myCar = new Car();

        System.out.println("Turining the car on...");
        myCar.switchOn();

        System.out.println("The car is switched on: " + myCar.isSwitchedOn());

        System.out.println("Turining the car off...");
        myCar.switchOff();
        System.out.println("The car is switched on: " + myCar.isSwitchedOn());


        System.out.println("");
        System.out.println("------------------------");
        System.out.println("");

        System.out.println("Creating a new Line...");
        Line myLine = new Line();
        
        System.out.print("The line has the following start point: ");
        System.out.println(myLine.getP1().getX() + "; " + myLine.getP1().getY());


        System.out.println("Now returning the start point and modifying it OUTSIDE of the line...");

        Point myStartingPoint = myLine.getP1Reference();

        // Point myStartingPoint = myLine.getP1();
        
        // Point myStartingPoint = myLine.getP1clone();

        // Point myStartingPoint = myLine.getP1copy();
                
        myStartingPoint.setX(5f);
        
        System.out.print("The line has the following start point: ");
        System.out.println(myLine.getP1().getX() + "; " + myLine.getP1().getY());
        
    }
        
}
