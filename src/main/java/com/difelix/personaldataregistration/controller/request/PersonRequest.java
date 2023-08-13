package com.difelix.personaldataregistration.controller.request;

import static com.difelix.personaldataregistration.utils.Constants.ONLY_LETTERS_REGEX;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonRequest {

  @NotBlank
  @Length(max = 200)
  @Pattern(regexp = ONLY_LETTERS_REGEX, message = "{only.letters.error}")
  private String name;

  @NotBlank
  @Email
  private String email;

  @NotBlank
  @CPF
  private String cpf;

  @NotBlank
  private String birthdate;

  @Valid
  @NotNull
  @Size(min = 1, max = 3)
  private List<AddressRequest> addresses;

  @Valid
  @NotNull
  @Size(min = 1, max = 3)
  private List<ContactRequest> contacts;
}
