package ch.hslu.oop.sw7;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private float x = 0;
    private float y = 0;
    
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Create a new Point by copying an existing Point.
     * @param pointToCopy
     */
    public Point(Point pointToCopy) {
        // call constructor instead of assigning this.x and this.y directly
        this(pointToCopy.x, pointToCopy.y);
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

    public void moveRelative(final float x, final float y){
        this.x += x;
        this.y += y;
    }

    public void moveRelative(final Point moveVector){
        this.moveRelative(moveVector.x, moveVector.y);
    }

    public void moveRelative(final float length, final double angle){
        this.moveRelative(
            (float) (Math.cos(angle) * length),
            (float) (Math.sin(angle) * length)
        );
    }

    @Override
    public final boolean equals(final Object object) {
        if(object == this){
            return true;
        }
        return (object instanceof Point p)
            && (Float.compare(this.x, p.x) == 0)
            && (Float.compare(this.y, p.y) == 0);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    @Override
    public final int compareTo(Point other) {
        if(this == other){
            return 0;
        }
        return Float.compare(this.x, other.x);

    } 


}