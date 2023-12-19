package ch.hslu.oop.sw06ex;

public abstract class Shape {
    private int x, y;

    protected Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public final void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public abstract int getPerimeter();

    public abstract int getArea();
}
