/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.hslu.oop.sw3;

/**
 *
 * @author JoëlAmmann
 */
public class Point {
    private int x, y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Determines the geometric quadrant in which the point is located. If the point lies on one of the axes, the return value is 0.
     *
     * @return The quadrant (1, 2, 3, or 4) in which the point is situated, or 0 if the point is on an axis.
     */
    public int getQuadrant() {
        if (this.x > 0 && this.y > 0) {
            return 1;
        } else if (this.x < 0 && this.y > 0) {
            return 2;
        } else if (this.x < 0 && this.y < 0) {
            return 3;
        } else if (this.x > 0 && this.y < 0) {
            return 4;
        } else {
            return 0;
        }
    }


}
