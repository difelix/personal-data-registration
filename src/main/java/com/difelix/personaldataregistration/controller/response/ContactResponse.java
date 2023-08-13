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
public class ContactResponse {
  private String label;
  private Boolean principal;
  private String ddd;
  private String phoneNumber;
  private Boolean whatsApp;
  private String createdAt;
  private String updatedAt;
}
