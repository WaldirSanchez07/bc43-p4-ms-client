package com.nttdata.msclient.infrastructure.controller;

import com.nttdata.msclient.application.dto.request.ClientSaveRequest;
import com.nttdata.msclient.application.dto.response.ObjectResponse;
import com.nttdata.msclient.application.service.ClientExternalService;
import com.nttdata.msclient.application.service.ProfileExternalService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiRest Full ClientController class.
 */
@AllArgsConstructor
@RestController
@RequestMapping("api/clients")
public class ClientController {

  private final ClientExternalService clientExtService;
  private final ProfileExternalService profileExtService;

  @GetMapping(value = "/profiles", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flowable<ObjectResponse> findAllProfiles() {
    return profileExtService.findAll();
  }

  @GetMapping(value = "/list", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flowable<ObjectResponse> findAllClients() {
    return clientExtService.findAll();
  }

  @GetMapping(value = "/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Maybe<ObjectResponse> findClientById(@PathVariable String id) {
    return clientExtService.findById(id);
  }

  @PostMapping(value = "/create", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Maybe<ObjectResponse> saveClient(@Valid @RequestBody ClientSaveRequest request) {
    return clientExtService.save(request);
  }

}
