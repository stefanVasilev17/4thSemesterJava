package com.informatics.CSCB869FinalProject.web.view;

import com.informatics.CSCB869FinalProject.customAnnotations.KindOfServiceValidation;
import com.informatics.CSCB869FinalProject.customAnnotations.RankValidation;

import com.informatics.CSCB869FinalProject.data.entity.Human;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class MechanicView extends Human
{
  @KindOfServiceValidation
  private String     qualification;
  @RankValidation
  private String     typeOfMechanic;
  private String     specializedCarBrand;
  @Min(800)
  @Digits(integer = 13, fraction = 2)
  private BigDecimal salary;
}
