package ch.hslu.oop.sw5;

public class Circle extends Shape{
    private int diameter;

    public Circle(int x, int y, int diameter) {
        super(x, y);
        this.diameter = diameter;
    }

    public final void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public final int getDiameter() {
        return this.diameter;
    }

    public final int getPerimeter() {
        return (int) (Math.PI * (double) this.diameter);
    }

    public final int getArea() {
        return (int) (Math.PI * Math.pow((this.diameter / 2), 2));
    }


}
