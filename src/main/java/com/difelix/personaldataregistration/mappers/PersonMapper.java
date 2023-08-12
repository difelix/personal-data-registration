package com.difelix.personaldataregistration.mappers;

import com.difelix.personaldataregistration.controller.request.PersonRequest;
import com.difelix.personaldataregistration.controller.response.PersonResponse;
import com.difelix.personaldataregistration.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = AddressMapper.class)
public interface PersonMapper {

  PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

  PersonResponse personToPersonResponse(Person person);

  Person personRequestToPerson(PersonRequest personRequest);
}
