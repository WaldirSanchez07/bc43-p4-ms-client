package com.nttdata.msclient.application.service;

import com.nttdata.msclient.application.dto.response.ObjectResponse;
import io.reactivex.rxjava3.core.Flowable;

/**
 * Define to methods.
 */
public interface ProfileExternalService {

  Flowable<ObjectResponse> findAll();

}
