package com.difelix.personaldataregistration.controller.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonRequest {

  @NotBlank
  private String name;

  @NotBlank
  private String email;

  @NotBlank
  private String cpf;

  @NotBlank
  private String birthdate;

  @Valid
  @Size(min = 1)
  private List<AddressRequest> addresses;
}
