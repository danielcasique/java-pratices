package org.casique.custom.annotation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Test {
  @IsParseableToInteger(fieldName = "number")
  private String number;
}
