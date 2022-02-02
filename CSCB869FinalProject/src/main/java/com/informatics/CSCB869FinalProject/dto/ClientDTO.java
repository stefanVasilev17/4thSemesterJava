package com.informatics.CSCB869FinalProject.dto;

import com.informatics.CSCB869FinalProject.data.entity.Garage;
import com.informatics.CSCB869FinalProject.data.entity.Human;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Validated
@NoArgsConstructor
public class ClientDTO extends Human
{
  private String telephoneNumber;

  @Min(20)
  private BigDecimal budget;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "garage_id")
  private Garage garage;
}
