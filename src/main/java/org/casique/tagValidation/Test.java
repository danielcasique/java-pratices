package org.casique.tagValidation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

public class Test {

  public static void main(String[] args) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    Example example = new Example();
    Example.E1EDP01 e1EDP01 = new Example.E1EDP01();
    Example.E1EDPT1 e1EDPT1 = new Example.E1EDPT1();
    Example.E1EDPT2 e1EDPT2 = new Example.E1EDPT2();

   // e1EDPT2.setTdline(""); // This should trigger the @NotBlank validation

    //e1EDPT1.setE1EDPT2(List.of(e1EDPT2));
    //e1EDP01.setE1EDPT1(e1EDPT1);
    example.setE1EDP01(List.of(e1EDP01));

    Set<ConstraintViolation<Example>> violations = validator.validate(example);
    for (ConstraintViolation<Example> violation : violations) {
      System.out.println(violation);
    }
  }

}
