package ch.hslu.oop.sw05ex;

public class Rectangle extends Shape {
    private int width, height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);

        this.width = width;
        this.height = height;
    }

    public void changeDimensions(int newWidth, int newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    @Override
    public final int getPerimeter() {
        return (2 * this.width) + (2 * this.height);
    }

    @Override
    public final int getArea() {
        return this.width * this.height;
    }
}
