package ch.hslu.oop.sw5;

public class Square extends Shape {
    private Rectangle rectangle;
    
    public Square(int x, int y, int size){
        super(x, y);
        
        //Position explicitly 0,0 - not used
        this.rectangle = new Rectangle(0, 0, size, size);
    }

    public final void changeDimensions(int newSize) {
        this.rectangle.changeDimensions(newSize, newSize);
    }

    @Override
    public final int getPerimeter(){
        return this.rectangle.getPerimeter();
    }

    @Override
    public final int getArea(){
        return this.rectangle.getArea();
    }

}
