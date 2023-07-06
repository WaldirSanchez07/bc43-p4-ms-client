package com.nttdata.msclient.application.mapper;

import com.nttdata.msclient.application.dto.request.ClientSaveRequest;
import com.nttdata.msclient.domain.model.Client;
import java.time.LocalDateTime;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for ClientRequest.
 */
@Mapper
public interface ClientRequestMapper {

  ClientRequestMapper INSTANCE = Mappers.getMapper(ClientRequestMapper.class);

  /**
   * ClientSaveRequest to Client.

   * @param clientRequest type ClientSaveRequest.
   * @return type Client.
   */
  default Client map(ClientSaveRequest clientRequest) {
    return Client.builder()
            .id(UUID.randomUUID().toString())
            .profileId(clientRequest.getProfileId())
            .dni(clientRequest.getDni())
            .firstName(clientRequest.getFirstName())
            .otherNames(clientRequest.getOtherNames())
            .firstSurname(clientRequest.getFirstSurname())
            .date(LocalDateTime.now())
            .build();
  }

}
