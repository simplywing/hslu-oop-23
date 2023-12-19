package ch.hslu.oop.sw09ex;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {

    public static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);

        do { LOG.info("Enter a temperature (or 'exit' to end the program): ");
            input = scanner.next();
            try {
                float value = Float.parseFloat(input);
                var temp = Temperature.fromCelsius(value);
                LOG.info(temp.toString());
            }
            catch (NumberFormatException e){
                LOG.warn("Could not convert Input to Float");
            }
            catch (IllegalArgumentException e){
                LOG.warn(e.getMessage());
            }

        } while (!"exit".equals(input));

        LOG.info("Program End.");
    }
}

