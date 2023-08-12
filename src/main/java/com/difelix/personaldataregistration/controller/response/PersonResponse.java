package com.difelix.personaldataregistration.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class PersonResponse {
  private String id;
  private String name;
  private String cpf;
  private String email;
  private String birthdate;
  private List<AddressResponse> addresses;
  private String createdAt;
  private String updatedAt;
}
