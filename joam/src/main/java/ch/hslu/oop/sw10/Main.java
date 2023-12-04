package ch.hslu.oop.sw10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {

    public static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);

        TemperatureHistory tempHistory = new TemperatureHistory();
        tempHistory.addTemperatureEventListener(new TemperatureEventListener() {
                public void temperatureExtremaChanged(TemperatureEvent evt){
                    LOG.info(evt.toString());
                }
            }
        );

        do { LOG.info("Enter a temperature (or 'exit' to end the program): ");
            input = scanner.next();

            if("exit".equals(input)){
                /* Print Stats and exit */
                if(tempHistory.getCount() > 0) {
                    LOG.info(String.format("Measurement Count: %s", tempHistory.getCount()));
                    LOG.info(String.format("Average Temp: %s", tempHistory.getAverage().get()));
                    LOG.info(String.format("Min: %s, Max: %s", tempHistory.getMin().get(), tempHistory.getMax().get()));
                }
            } else if ("clear".equals(input)) {
                tempHistory.clear();
                LOG.info("Temp history cleared.");
            } else {
                try {
                    float value = Float.parseFloat(input);
                    var temp = Temperature.fromCelsius(value);
                    LOG.info(temp.toString());

                    tempHistory.add(temp);
                }
                catch (NumberFormatException e){
                    LOG.warn("Could not convert Input to Float");
                }
                catch (IllegalArgumentException e){
                    LOG.warn(e.getMessage());
                }
            }

        } while (!"exit".equals(input));

        LOG.info("Program End.");
    }
}

