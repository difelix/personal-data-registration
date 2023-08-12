package com.difelix.personaldataregistration.service.impl;

import com.difelix.personaldataregistration.entity.Person;
import com.difelix.personaldataregistration.repository.PersonRepository;
import com.difelix.personaldataregistration.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;

  @Override
  public Person save(Person person) {
    return personRepository.save(person);
  }
}
