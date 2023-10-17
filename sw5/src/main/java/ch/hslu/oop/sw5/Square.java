package ch.hslu.oop.sw5;

public class Square extends Rectangle {
    
    public Square(int x, int y, int size){
        super(x, y, size, size);
    }

    public final void changeDimensions(int newSize) {
        super.changeDimensions(newSize, newSize);
    }

    /**
     * This method is implemented as a safeguard to prevent a square with unequal widths.
     * @param newWidth new size for the quare
     * @param newHeight ! will be ignored ! 
     */
    @Override
    public void changeDimensions(int newWidth, int newHeight) {
        super.changeDimensions(newWidth, newWidth);
    }

}
