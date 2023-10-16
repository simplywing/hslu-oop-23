package ch.hslu.oop.sw4;

public class Point implements Cloneable {
    private float x = 0;
    private float y = 0;
    
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public void setX(final float x) {
        this.x = x;
    }

    public void setY(final float y) {
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    @Override
    public Point clone() {
        return new Point (this.x, this.y);
    }

}