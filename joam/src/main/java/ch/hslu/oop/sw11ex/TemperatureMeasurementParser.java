package ch.hslu.oop.sw11ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class TemperatureMeasurementParser {

    private Path filePath;

    private Logger LOG = LoggerFactory.getLogger(TemperatureMeasurementParser.class);

    public static TemperatureMeasurementParser of(String filePath) {
        var parser = new TemperatureMeasurementParser();
        parser.setFilePath(filePath);
        return parser;
    }

    public String getFilePath() {
        return filePath.toString();
    }

    public void setFilePath(String filePath) {
        this.filePath = Path.of(filePath);
    }

    public void printMeasurements() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath.toFile(), StandardCharsets.UTF_8))) {
            br.lines()
                    .map(this::extractMeasurement)
                    .forEach(System.out::println);
        } catch (IOException e) {
            LOG.error(e.toString());
        }
    }

    public TemperatureMeasurementHistory getTemperatureMeasurementHistory() {
        var history = new TemperatureMeasurementHistory();

        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath.toFile(), StandardCharsets.UTF_8))) {
            br.lines()
                    .map(this::extractMeasurement)
                    .forEach(history::add);
        } catch (IOException e) {
            LOG.error(e.toString());
        }

        return history;
    }

    private TemperatureMeasurement extractMeasurement(final String line) {
        DateTimeFormatter DateTimeFormatter;
        return new TemperatureMeasurement(
                LocalDateTime.parse(line.split(";")[1], java.time.format.DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\"")),
                Temperature.fromCelsius(Float.parseFloat(line.split(";")[2]))
        );
    }

}
