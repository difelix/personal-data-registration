package com.difelix.personaldataregistration.mappers;

import com.difelix.personaldataregistration.controller.request.AddressRequest;
import com.difelix.personaldataregistration.controller.response.AddressResponse;
import com.difelix.personaldataregistration.entity.Address;
import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper {
  Address addressRequestToAddress(AddressRequest addressRequest);

  AddressResponse addressToAddressToResponse(Address address);
}
