package com.informatics.CSCB869FinalProject.web.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.informatics.CSCB869FinalProject.data.entity.Human;
import com.informatics.CSCB869FinalProject.data.entity.Vehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ClientView extends Human
{
  private String telephoneNumber;
  private String budget;

  @JsonIgnoreProperties({"client", "mechanic"})
  private List<Vehicle> ownedVehicles;
}
