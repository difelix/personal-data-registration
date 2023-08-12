package com.difelix.personaldataregistration.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

  @NotBlank
  private String label;

  @NotBlank
  private String cep;

  @NotBlank
  private String street;

  @NotNull
  private int number;

  @NotBlank
  private String neighborhood;

  @NotBlank
  private String city;

  @NotBlank
  private String state;

  @NotNull
  private Boolean isPrincipal;

  private String complement;
}
