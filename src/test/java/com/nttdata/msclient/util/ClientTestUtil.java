package com.nttdata.msclient.util;

import com.nttdata.msclient.application.dto.request.ClientSaveRequest;
import com.nttdata.msclient.application.dto.response.ObjectResponse;
import com.nttdata.msclient.domain.model.Client;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

public class ClientTestUtil {

  public static Maybe<ObjectResponse> generateClient() {
    Client client1 = Client.builder()
            .id("1")
            .dni("40503020")
            .firstName("Juan")
            .build();

    ObjectResponse obj1 = ObjectResponse.builder()
            .status(200)
            .message(null)
            .data(client1)
            .build();

    return Maybe.just(obj1);
  }

  public static ClientSaveRequest generateClientRequest() {
    ClientSaveRequest request = ClientSaveRequest.builder()
            .profileId("P1")
            .dni("40503020")
            .firstName("Juan")
            .otherNames("Jose")
            .firstSurname("Robles")
            .secondSurname("Lopez")
            .build();

    return request;
  }

  public static Flowable<ObjectResponse> generateListClients() {
    Client client1 = Client.builder()
            .id("1")
            .dni("40503020")
            .firstName("Juan")
            .build();

    Client client2 = Client.builder()
            .id("1")
            .dni("40503010")
            .firstName("Jorge")
            .build();

    ObjectResponse obj1 = ObjectResponse.builder()
            .status(200)
            .message(null)
            .data(client1)
            .build();

    ObjectResponse obj2 = ObjectResponse.builder()
            .status(200)
            .message(null)
            .data(client2)
            .build();

    return Flowable.just(obj1, obj2);
  }

}
