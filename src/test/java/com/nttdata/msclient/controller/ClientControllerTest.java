package com.nttdata.msclient.controller;

import com.nttdata.msclient.application.dto.request.ClientSaveRequest;
import com.nttdata.msclient.application.dto.response.ObjectResponse;
import com.nttdata.msclient.application.service.ClientExternalService;
import com.nttdata.msclient.application.service.ProfileExternalService;
import com.nttdata.msclient.infrastructure.controller.ClientController;
import io.reactivex.rxjava3.core.Flowable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.nttdata.msclient.util.ClientTestUtil.*;
import static com.nttdata.msclient.util.ProfileTestUtil.generateListProfiles;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(ClientControllerTest.class)
public class ClientControllerTest {

  @InjectMocks
  ClientController clientController;

  @Mock
  private ProfileExternalService profileExtService;

  @Mock
  private ClientExternalService clientExtService;

  @Test
  public void testEmptyFindAllProfiles() {
    when(profileExtService.findAll()).thenReturn(Flowable.empty());

    WebTestClient client = WebTestClient.bindToController(clientController).build();

    client.get().uri("/api/clients/list")
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .valueMatches("Content-Type", "text/event-stream(;charset=UTF-8)?");
  }

  @Test
  public void testFindAllProfiles() {
    when(profileExtService.findAll()).thenReturn(generateListProfiles());

    WebTestClient client = WebTestClient.bindToController(clientController).build();

    client.get().uri("/api/clients/profiles")
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .valueMatches("Content-Type", "text/event-stream(;charset=UTF-8)?");
  }

  @Test
  public void testEmptyFindAllClients() {
    when(clientExtService.findAll()).thenReturn(Flowable.empty());

    WebTestClient client = WebTestClient.bindToController(clientController).build();

    client.get().uri("/api/clients/list")
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .valueMatches("Content-Type", "text/event-stream(;charset=UTF-8)?");
  }

  @Test
  public void testFindAllClients() {
    when(clientExtService.findAll()).thenReturn(generateListClients());

    WebTestClient client = WebTestClient.bindToController(clientController).build();

    client.get().uri("/api/clients/list")
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .valueMatches("Content-Type", "text/event-stream(;charset=UTF-8)?")
            .expectBodyList(ObjectResponse.class)
            .hasSize(2);
  }

  @Test
  public void testFindClientById() {
    when(clientExtService.findById(anyString())).thenReturn(generateClient());

    WebTestClient client = WebTestClient.bindToController(clientController).build();

    client.get()
            .uri("/api/clients/1")
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .valueMatches("Content-Type", "text/event-stream(;charset=UTF-8)?")
            .returnResult(ObjectResponse.class)
            .consumeWith(o -> {
              Assertions.assertEquals(o.getResponseBody().blockFirst().getStatus(), 200);
            });
  }

  @Test
  public void testSaveClient() {
    when(clientExtService.save(any(ClientSaveRequest.class))).thenReturn(generateClient());

    WebTestClient client = WebTestClient.bindToController(clientController).build();

    client.post()
            .uri("/api/clients/create")
            .contentType(MediaType.APPLICATION_JSON)
            .syncBody(generateClientRequest())
            .exchange()
            .expectStatus()
            .isOk()
            .returnResult(ObjectResponse.class)
            .consumeWith(o -> {
              Assertions.assertEquals(o.getResponseBody().blockFirst().getStatus(), 200);
            });
  }

}
