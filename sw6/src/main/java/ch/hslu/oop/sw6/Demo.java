package ch.hslu.oop.sw6;

public class Demo {
    public static int max(final int a, final int b, final int c) {
        int max = a;
        max = (b > max) ? b : max;
        max = (c > max) ? c : max;
        return max;
    }
}
