package com.nttdata.msclient.infrastructure.mapper;

import com.nttdata.msclient.domain.model.Client;
import com.nttdata.msclient.infrastructure.dao.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Transform ClientEntity to Client after save.
 */
@Mapper
public interface ClientAfterSaveMapper {

  ClientAfterSaveMapper INSTANCE = Mappers.getMapper(ClientAfterSaveMapper.class);

  /**
   * Transform ClientEntity to Client.
   *
   * @param client client model.
   * @return client model.
   */
  default Client map(ClientEntity client) {
    return Client.builder()
            .id(client.getId())
            .dni(client.getDni())
            .profileId(client.getProfileId())
            .firstName(client.getFirstName())
            .otherNames(client.getOtherNames())
            .firstSurname(client.getFirstSurname())
            .secondSurname(client.getSecondSurname())
            .date(client.getDate())
            .build();
  }

}
