package ch.hslu.oop.sw11;

import java.time.LocalDateTime;
import java.util.Objects;

public record TemperatureMeasurement(LocalDateTime timestamp, Temperature measurement) implements Comparable<TemperatureMeasurement> {
    @Override
    public String toString() {
        return "TemperatureMeasurement{" +
                "timestamp=" + timestamp +
                ", measurement=" + measurement +
                '}';
    }

    @Override
    public int compareTo(TemperatureMeasurement o) {
        return this.measurement.compareTo(o.measurement());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemperatureMeasurement that = (TemperatureMeasurement) o;
        return Objects.equals(timestamp, that.timestamp) && Objects.equals(measurement, that.measurement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, measurement);
    }
}
