package org.casique.oop.designPattern.structural.facade;

//this code belongs to https://github.com/eugenp/tutorials/blob/master/patterns-modules/design-patterns-structural/src/main/java/com/baeldung/facade/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Radiator {

    private static final Logger LOGGER = LoggerFactory.getLogger(Radiator.class);

    public void on(){
        LOGGER.info("Radiator switched on!");
    }

    public void off(){
        LOGGER.info("Radiator switched off!");
    }

    public void setSpeed(Integer speed){
        LOGGER.info("Setting radiator speed to {}",speed);
    }
}
