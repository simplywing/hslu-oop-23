/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ch.hslu.oop.sw3;

/**
 *
 * @author JoëlAmmann
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int maxVal = Demo.max(5, 5, 1);
        System.out.println("Max: " + maxVal);


        int maxVal2 = Demo.max2(6, 1, -3);
        System.out.println("Max: " + maxVal2);


        AggregateState aggregateState = new Temperature(100).getAggregateState("N");
        System.out.println("AggregateState (N): " + aggregateState);

        Temperature myTemp = new Temperature(400f);
        myTemp.printDebug();
        System.out.println("AggregateState (Pb): " + myTemp.getAggregateState("Pb"));

        System.out.println("-> 1-10 mit einer For-Schleife:");
        Demo.printOneToTen();

        System.out.println("-> 1-10 mit einer While-Schleife:");
        Demo.printOneToTenWhileLoop();

        System.out.println("-> Float hochaddieren:");
        Demo.iterativeAddToFloat();

        System.out.println("-> Float hochaddieren (4000 Iterationen):");
        Demo.iterativeAddToFloatFixedIterations();

        System.out.println("-> printBox:");
        Demo.printBox(10, 4);

        System.out.println("-> printCross:");
        
        Demo.printCross(5);

        System.out.println("-> printSwissCross:");
        
        Demo.printSwissCross(9, 3);


    }
}

