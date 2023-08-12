package com.difelix.personaldataregistration.repository;

import com.difelix.personaldataregistration.entity.Person;
import java.util.UUID;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface PersonRepository extends CrudRepository<Person, UUID> {
}
