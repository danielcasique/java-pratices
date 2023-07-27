package org.casique.validators;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * this code is provided by chatGPT
 */
@Getter
@Setter
public class Person {
  @NotNull
  private String name;

  @NotNull
  private Integer age;
}

