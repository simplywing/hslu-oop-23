package ch.hslu.oop.sw4;

public class Line {
    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Line(float x1, float y1, float x2, float y2) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    public Line() {
        this.p1 = new Point(0f, 0f);
        this.p2 = new Point(0f, 0f);
    }

    /**
     * BAD EXAMPLE - This method returns a reference to the internal Point object
     * @return Point object of starting point
     */
    public Point getP1Reference() {
        return this.p1;
    }

    /**
     * BAD EXAMPLE - This method returns a reference to the internal Point object
     * @return Point object of end point
     */
    public Point getP2Reference() {
        return this.p2;
    }
     
    public Point getP1() {
        return (new Point(this.p1.getX(), this.p1.getY()));
    }

    public Point getP1clone() {
        return this.p1.clone();
    }

    public Point getP2clone() {
        return this.p1.clone();
    }

    public Point getP2() {
        return (new Point(this.p2.getX(), this.p2.getY()));
    }

    public void setP1(final Point p1) {
        this.p1 = p1;
    }

    public void setP2(final Point p2) {
        this.p2 = p2;
    }

    public void setP1(final float x, final float y) {
        this.p1.setX(x);
        this.p1.setY(y);
    }

    public void setP2(final float x, final float y) {
        this.p2.setX(x);
        this.p2.setY(y);
    }

    public float getLength() {
        return (float) Math.sqrt(Math.pow(this.p2.getX() - this.p1.getX(), 2)
                + Math.pow(this.p2.getY() - this.p1.getY(), 2));
    }

}
