package org.casique.custom.annotation;

import static org.casique.custom.annotation.Constants.ERROR_INTEGER;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.math.Fraction;

@Data
@Builder
public class Car {
  @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = ERROR_INTEGER)
  @NotBlank
  private String maxPassengers;

}
