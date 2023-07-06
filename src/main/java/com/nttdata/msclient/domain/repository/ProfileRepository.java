package com.nttdata.msclient.domain.repository;

import com.nttdata.msclient.domain.model.Profile;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;

/**
 * Interface to define methods.
 */
public interface ProfileRepository {

  Flowable<Profile> findAll();

  Maybe<Profile> findById(String id);

}
