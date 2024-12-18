package org.casique.custom.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IntegerValidator implements ConstraintValidator<IsParseableToInteger, String> {

  private String fieldName;
  private static final String ERROR_PARSING = "The field [%s] cannot be parsed to Integer. Current Value : [%s]";

  @Override
  public void initialize(IsParseableToInteger constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
    this.fieldName = constraintAnnotation.fieldName();
      }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
    if (value == null || value.isEmpty()) {
      return true;
    }
    try{
      Integer.parseInt(value);
      return true;
    }catch (Exception e){
      constraintValidatorContext.disableDefaultConstraintViolation();
      constraintValidatorContext.buildConstraintViolationWithTemplate(ERROR_PARSING.formatted(fieldName, value)).addConstraintViolation();
      return false;
    }
  }
}
