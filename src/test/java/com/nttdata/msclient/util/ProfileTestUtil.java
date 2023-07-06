package com.nttdata.msclient.util;

import com.nttdata.msclient.application.dto.response.ObjectResponse;
import com.nttdata.msclient.domain.model.Profile;
import io.reactivex.rxjava3.core.Flowable;

public class ProfileTestUtil {

  public static Flowable<ObjectResponse> generateListProfiles() {

    Profile profile = Profile.builder()
            .id("1")
            .name("Personal")
            .build();

    ObjectResponse obj = ObjectResponse.builder()
            .status(200)
            .message(null)
            .data(profile)
            .build();

    return Flowable.just(obj);
  }

}
