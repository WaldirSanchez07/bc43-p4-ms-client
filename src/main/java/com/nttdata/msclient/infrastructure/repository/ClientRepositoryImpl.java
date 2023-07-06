package com.nttdata.msclient.infrastructure.repository;

import com.nttdata.msclient.domain.model.Client;
import com.nttdata.msclient.domain.repository.ClientRepository;
import com.nttdata.msclient.infrastructure.dao.repository.ClientRepositoryReactive;
import com.nttdata.msclient.infrastructure.mapper.ClientAfterSaveMapper;
import com.nttdata.msclient.infrastructure.mapper.ClientMapper;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * ClientRepository implementation.
 */
@Repository
@AllArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

  private final ClientRepositoryReactive clientRepository;

  @Override
  public Flowable<Client> findAll() {
    return clientRepository.customFindAll()
            .map(ClientMapper.INSTANCE::map);
  }

  @Override
  public Maybe<Client> findById(String id) {
    return clientRepository.customFindById(id)
            .map(ClientMapper.INSTANCE::map);
  }

  @Override
  public Maybe<String> findDniByDni(String dni) {
    return clientRepository.findDniByDni(dni);
  }

  @Override
  public Maybe<Client> save(Client client) {
    Mono<Client> mono = clientRepository
            .save(ClientMapper.INSTANCE.map(client))
            .map(ClientAfterSaveMapper.INSTANCE::map);

    return Maybe.fromPublisher(mono);
  }

}
