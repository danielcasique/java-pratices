package org.casique.oop.designPattern.structural.facade;

//this code belongs to https://github.com/eugenp/tutorials/blob/master/patterns-modules/design-patterns-structural/src/main/java/com/baeldung/facade/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FuelPump {

    private static final Logger LOGGER = LoggerFactory.getLogger(FuelPump.class);

    public void pump() {
        LOGGER.info("Fuel Pump is pumping fuel..");
    }
}
