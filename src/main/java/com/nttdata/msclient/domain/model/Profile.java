package com.nttdata.msclient.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Profile model.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

  private String id;
  private String name;

}
