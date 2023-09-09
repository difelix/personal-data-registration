package com.difelix.personaldataregistration.service;

import com.difelix.personaldataregistration.entity.Person;
import com.difelix.personaldataregistration.repository.PersonRepository;
import com.difelix.personaldataregistration.service.impl.PersonServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

  @Mock
  private PersonRepository personRepository;

  @InjectMocks
  private PersonServiceImpl personService;

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  void shouldSavePersonWithSuccess() throws IOException {
    final Person person = objectMapper
        .readValue(new URL("file:src/test/resources/payloads/save_person_success.json"), Person.class);

    Mockito.when(personRepository.save(person)).thenReturn(person);

    final Person personSaved = personService.save(person);

    Assertions.assertNotNull(personSaved);
    Mockito.verify(personRepository, Mockito.times(1)).save(person);
  }
}
