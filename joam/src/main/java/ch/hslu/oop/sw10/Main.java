package ch.hslu.oop.sw10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        LOG.info("Creating a new Car...");
        var myCar = new Car();
        myCar.switchOn();
        myCar.speedUp();

        myCar.switchOff();
        myCar.speedUp();

        myCar.slowDown();
        myCar.slowDown();
        myCar.slowDown();
    }
}

