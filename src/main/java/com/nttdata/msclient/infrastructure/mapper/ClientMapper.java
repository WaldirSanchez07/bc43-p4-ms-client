package com.nttdata.msclient.infrastructure.mapper;

import com.nttdata.msclient.domain.model.Client;
import com.nttdata.msclient.domain.model.Profile;
import com.nttdata.msclient.infrastructure.dao.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Transforming class.
 */
@Mapper
public interface ClientMapper {

  ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

  /**
   * ClientEntity to Client.

   * @param client type ClientEntity.
   * @return type client model.
   */
  default Client map(ClientEntity client) {
    return Client.builder()
            .id(client.getId())
            .dni(client.getDni())
            .profileId(client.getProfileId())
            .profile(Profile.builder()
                    .id(client.getProfile().getId())
                    .name(client.getProfile().getName())
                    .build())
            .firstName(client.getFirstName())
            .otherNames(client.getOtherNames())
            .firstSurname(client.getFirstSurname())
            .secondSurname(client.getSecondSurname())
            .date(client.getDate())
            .build();
  }

  /**
   * Client to ClientEntity.

   * @param client type model client.
   * @return type ClientEntity.
   */
  default ClientEntity map(Client client) {
    return ClientEntity.builder()
            .id(client.getId())
            .profileId(client.getProfileId())
            .dni(client.getDni())
            .firstName(client.getFirstName())
            .otherNames(client.getOtherNames())
            .firstSurname(client.getFirstSurname())
            .secondSurname(client.getSecondSurname())
            .date(client.getDate())
            .build();
  }

}
