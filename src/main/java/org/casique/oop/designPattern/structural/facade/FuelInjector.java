package org.casique.oop.designPattern.structural.facade;

//this code belongs to https://github.com/eugenp/tutorials/blob/master/patterns-modules/design-patterns-structural/src/main/java/com/baeldung/facade/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FuelInjector {
    private static final Logger LOGGER = LoggerFactory.getLogger(FuelInjector.class);

    private FuelPump fuelPump = new FuelPump();

    public void on(){
        LOGGER.info("Fuel injector ready to inject fuel.");
    }

    public void inject() {
        fuelPump.pump();
        LOGGER.info("Fuel injected.");
    }

    public void off() {
        LOGGER.info("Stopping Fuel injector..");
    }
}