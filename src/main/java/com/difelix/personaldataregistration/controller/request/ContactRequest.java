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
public class ContactRequest {

  @NotBlank
  private String label;

  @NotNull
  private Boolean principal;

  @NotBlank
  private String ddd;

  @NotBlank
  private String phoneNumber;

  @NotNull
  private Boolean whatsApp;
}
