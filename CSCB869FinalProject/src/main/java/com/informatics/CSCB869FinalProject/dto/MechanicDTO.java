package com.informatics.CSCB869FinalProject.dto;

import com.informatics.CSCB869FinalProject.data.entity.Human;
import com.informatics.CSCB869FinalProject.data.entity.KindOfServices;
import com.informatics.CSCB869FinalProject.data.entity.Rank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class MechanicDTO extends Human
{
  private KindOfServices qualification;
  private Rank           typeOfMechanic;
  private String         specializedCarBrand;
  @Min(800)
  @Digits(integer = 13, fraction = 2)
  private BigDecimal     salary;
}
