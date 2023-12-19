package ch.hslu.oop.sw03ex;

public class Demo {
    public static int min(final int a, final int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    public static int max(final int a, final int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static int max(final int a, final int b, final int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }

    public static int max2(final int a, final int b, final int c) {
        int max = a;
        max = (b > max) ? b : max;
        max = (c > max) ? c : max;
        return max;
    }

    public static void printOneToTen() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }

    public static void printOneToTenWhileLoop() {
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }

    public static void iterativeAddToFloat() {
        float sum = 0.9f;
        int iterations = 0;
        while (sum <= 1.0f) {
            sum += 0.000025f;
            iterations++;
            // System.out.println("Current Value: " + sum + " Iterations: " + iterations);
        }

        System.out.println("Final Value: " + sum + " Iterations: " + iterations);
    }

    public static void iterativeAddToFloatFixedIterations() {
        float sum = 0.9f;
        for (int i = 0; i < 4000; i++) {
            sum += 0.000025f;
            // System.out.println("Current Value: " + sum + " Iterations: " + (int)(i + 1));
        }

        System.out.println("Final Value: " + sum);

    }

    public static void printBox(final int width, final int height) {
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                if (j == 0 || j == height - 1 || i == 0 || i == width - 1) {
                    System.out.print("#");
                } else {
                    // fill Box with whitespace
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    public static void printCross(final int size) {
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {

                if (i == size / 2 || j == size / 2) {
                    System.out.print("#");
                } else {
                    // fill Box with whitespace
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    /**
     * print a swiss cross with a given size and a given thickness
     * @param size total width and height of the cross
     */
    public static void printSwissCross(final int size, final int thickness) {
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {

                if (i >= size / 2 - thickness / 2 && i <= size / 2 + thickness / 2 ||
                        j >= size / 2 - thickness / 2 && j <= size / 2 + thickness / 2) {
                    System.out.print("#");
                } else {
                    // fill Box with whitespace
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

}
