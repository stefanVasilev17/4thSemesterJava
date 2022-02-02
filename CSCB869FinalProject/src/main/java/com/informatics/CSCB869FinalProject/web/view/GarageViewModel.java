package com.informatics.CSCB869FinalProject.web.view;

import com.informatics.CSCB869FinalProject.data.entity.KindOfServices;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class GarageViewModel
{
  private String         name;
  private KindOfServices kindOfServices;

  private Integer maxNumberOfCars;

  private Integer currentNumberOfCars;

  private Integer hiredEmployees;

  private BigDecimal dayBudget;

  private BigDecimal turnOver;

  private LocalDate foundationDate;
}
