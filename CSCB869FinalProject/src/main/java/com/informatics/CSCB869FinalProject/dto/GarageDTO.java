package com.informatics.CSCB869FinalProject.dto;

import com.informatics.CSCB869FinalProject.data.entity.KindOfServices;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class GarageDTO
{
  private String         name;
  private KindOfServices kindOfServices;
  private Integer        maxNumberOfCars;
  private Integer        currentNumberOfCars;
  private Integer        hiredEmployees;
  private BigDecimal     dayBudget;
  private BigDecimal     turnOver;

}
