package com.difelix.personaldataregistration.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AddressResponse {
  private String label;
  private String cep;
  private String street;
  private int number;
  private String neighborhood;
  private String city;
  private String state;
  private Boolean isPrincipal;
  private String complement;
  private String createdAt;
  private String updatedAt;
}
