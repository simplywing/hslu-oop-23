package ch.hslu.oop.sw9;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);

        do { System.out.println("Enter a temperature (or 'exit' to end the program): ");
            input = scanner.next();
            try {
                float value = Float.parseFloat(input);
                var temp = Temperature.fromCelsius(value);
                System.out.println(temp.toString());
            }
            catch (NumberFormatException e){
                System.out.println("Could not convert Input to Float");
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        } while (!"exit".equals(input));

        System.out.println("program end.");
    }
}

