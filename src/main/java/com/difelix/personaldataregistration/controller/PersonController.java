package com.difelix.personaldataregistration.controller;

import com.difelix.personaldataregistration.controller.request.PersonRequest;
import com.difelix.personaldataregistration.controller.response.PersonResponse;
import com.difelix.personaldataregistration.entity.Person;
import com.difelix.personaldataregistration.mappers.PersonMapper;
import com.difelix.personaldataregistration.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/person")
@RequiredArgsConstructor
public class PersonController {

  private final PersonService personService;

  @Operation(summary = "Save a new customer")
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public PersonResponse save(@RequestBody @Valid PersonRequest personRequest) {
    Person person = PersonMapper.INSTANCE.personRequestToPerson(personRequest);
    person = personService.save(person);
    return PersonMapper.INSTANCE.personToPersonResponse(person);
  }
}
