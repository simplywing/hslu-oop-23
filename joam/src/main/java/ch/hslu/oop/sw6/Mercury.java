package ch.hslu.oop.sw6;

public class Mercury extends Element {
    public Mercury(){
        super(200.59f,  234.3210f, 629.88f, 1499);
    }

    @Override
    public String toString(){
        return super.toString() + " GIFTIG!";
    }
}
