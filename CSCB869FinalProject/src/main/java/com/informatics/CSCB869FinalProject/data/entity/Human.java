package com.informatics.CSCB869FinalProject.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Human extends BaseEntity
{
  //@NotBlank
  private String name;

  private String surname;

}

