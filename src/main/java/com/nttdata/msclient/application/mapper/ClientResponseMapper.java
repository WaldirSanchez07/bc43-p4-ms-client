package com.nttdata.msclient.application.mapper;

import com.nttdata.msclient.application.dto.response.ClientResponse;
import com.nttdata.msclient.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper class.
 */
@Mapper
public interface ClientResponseMapper {

  ClientResponseMapper INSTANCE = Mappers.getMapper(ClientResponseMapper.class);

  /**
   * Client to ClientResponse.

   * @param client type Client.
   * @return type ClientResponse.
   */
  default ClientResponse map(Client client) {
    return ClientResponse.builder()
            .id(client.getId())
            .dni(client.getDni())
            .firstName(client.getFirstName())
            .otherNames(client.getOtherNames())
            .firstSurname(client.getFirstSurname())
            .secondSurname(client.getSecondSurname())
            .profile(client.getProfile())
            .build();
  }

}
