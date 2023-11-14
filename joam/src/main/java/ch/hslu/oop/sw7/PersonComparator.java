package ch.hslu.oop.sw7;

import java.util.Comparator;
import java.util.Objects;

public class PersonComparator implements Comparator<Person> {
    public final int compare(Person first, Person second) {
        int lastNameCompare = first.getLastname().compareTo(second.getLastname());
        if(lastNameCompare == 0){
            return first.getFirstname().compareTo(second.getFirstname());
        }
        return lastNameCompare;
    }

    public final boolean equals(Object object) {
        return object instanceof PersonComparator;
    }

    public final int hashCode() {
        return Objects.hash(this.getClass());
    }
}
