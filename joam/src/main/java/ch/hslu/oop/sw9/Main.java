package ch.hslu.oop.sw9;


import java.text.spi.NumberFormatProvider;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);

        do { System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            try {
                float value = Float.parseFloat(input);
                var temp = Temperature.fromKelvin(value);
                System.out.println(temp.toString());
            }
            catch (NumberFormatException e){
                System.out.println("Could not convert Input to Float");
            }
        } while (!"exit".equals(input));

        System.out.println("Programm beendet.");
    }
}

