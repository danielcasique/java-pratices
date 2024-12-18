package org.casique.custom.annotation;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.apache.commons.lang3.math.NumberUtils;

public class TestCustomAnnotation {

  public static void main(String[] args) {
    //Test test1 = Test.builder().number("aaa").build();
    Car car1 = Car.builder().maxPassengers("39990285681111111145446456").build();
/*
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    var violations = validator.validate(test1);
    if (!violations.isEmpty()) {
      for (var violation : violations) {
        System.out.println(violation.getMessage());
      }
    }
*/
    NumberUtils.INTEGER_ZERO
    ValidatorFactory factoryCar = Validation.buildDefaultValidatorFactory();
    Validator validatorCar = factoryCar.getValidator();
    var violationsCar = validatorCar.validate(car1);
    if (!violationsCar.isEmpty()) {
      for (var violation : violationsCar) {
        System.out.println(violation.getMessage());
      }
    }

  }
}
