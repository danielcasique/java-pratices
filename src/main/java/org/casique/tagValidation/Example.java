package org.casique.tagValidation;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Example {
  @JsonProperty("E1EDP01")
  @Valid
  private List<E1EDP01> e1EDP01;

  @NoArgsConstructor
  @Data
  public static class E1EDP01 {
    @JsonProperty("E1EDPT1")
    @NotNull
    @Valid
    private E1EDPT1 e1EDPT1;
  }

  @NoArgsConstructor
  @Data
  public static class E1EDPT1 {
    @JsonProperty("E1EDPT2")
    @NotNull
    @Valid
    private List<E1EDPT2> e1EDPT2;
  }

  @NoArgsConstructor
  @Data
  public static class E1EDPT2 {
    @JsonProperty("TDLINE")
    @NotBlank
    private String tdline;

    @JsonProperty("TDFORMAT")
    private String tdformat;
  }
}
