package org.casique.validators2;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class First {
  @Valid
  @NotNull
  Second second;

  @NotBlank
  String third;
}
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Second {
  @NotBlank
  String second1;

  @NotBlank
  String second2;

  String second3;
}

class ValidationUtils {
  private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  private static final Validator validator = factory.getValidator();

  public static <T> void validate(T object) {
    if (Objects.isNull(object)) {
      return;
    }
    Set<ConstraintViolation<T>> violations = validator.validate(
        object);
    violations.stream().forEach(x -> System.out.println(x.getPropertyPath() + " : " + x.getMessage()));
  }
}
public class Test {

  private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  private static final Validator validator = factory.getValidator();
  public static void main(String[] args) {

    First test = new First();
    test.setSecond(new Second());
    test.getSecond().setSecond3("second3");
    

    ValidationUtils.validate(test);


  }
}
