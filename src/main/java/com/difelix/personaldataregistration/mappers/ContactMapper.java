package com.difelix.personaldataregistration.mappers;

import com.difelix.personaldataregistration.controller.request.ContactRequest;
import com.difelix.personaldataregistration.controller.response.ContactResponse;
import com.difelix.personaldataregistration.entity.Contact;
import org.mapstruct.Mapper;

@Mapper
public interface ContactMapper {

  Contact contactRequestToContact(ContactRequest contactRequest);

  ContactResponse contactToContactResponse(Contact contact);
}
