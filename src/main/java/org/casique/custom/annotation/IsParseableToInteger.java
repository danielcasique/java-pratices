package org.casique.custom.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IntegerValidator.class) // Specify the validator class
@Target({  ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsParseableToInteger {
  String message() default "Invalid integer value";
  String fieldName() default "";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
