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
        
        Switchable myMotor = new Motor();
        Switchable myCar = new Car();
        Switchable myWiper = new Wiper();

        myCar.switchOn();
        myMotor.switchOn();
        myWiper.switchOn();

        System.out.println(myMotor.isSwitchedOn());
        myMotor.switchOff();
        System.out.println(myMotor.isSwitchedOn());


        Line myLine = new Line();
        
        System.out.println(myLine.getP1().getX() + "; " + myLine.getP1().getY());

        //This method returns a reference to the Line-Object's internal Point Object (BAD)
        Point myStartingPoint = myLine.getP1Reference();

        //This method returns a new Point object based on the values of the internal point Object (GOOD)
        Point myStartingPoint2 = myLine.getP1();
                
        myStartingPoint.setX(5f);
        
        System.out.println(myLine.getP1().getX() + "; " + myLine.getP1().getY());
        
    }
        
}
