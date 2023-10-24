/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ch.hslu.oop.sw6;

/**
 *
 * @author JoëlAmmann
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");


        System.out.println("\n--------------------------\n");

        Mercury myMercury = new Mercury();
        System.out.println(myMercury.toString());

        System.out.println("\n--------------------------\n");

        System.out.println("Moving a Rectangle with static type of Shape...");
        Shape myRect = new Rectangle(3, 10, 4, 6);
        myRect.move(3, 6);

        System.out.println("Get diameter of circle Object with static type of Shape by casting it to a Circle...");
        Shape myCircle = new Circle(5, 6, 9);
        ((Circle) myCircle).getDiameter();

        System.out.println("\n--------------------------\n");

    }
}
