package com.informatics.CSCB869FinalProject.services;

import com.informatics.CSCB869FinalProject.data.entity.Mechanic;
import com.informatics.CSCB869FinalProject.dto.MechanicDTO;
import com.informatics.CSCB869FinalProject.web.view.MechanicView;

import java.util.List;

public interface MechanicService
{
  List<MechanicDTO> getMechanicsByGarageId(Long id);

  Mechanic hireMechanic(Mechanic hireMechanic);

  void fireMechanic(Long id);

  List<Mechanic> findAllMechanicsByGarageId(Long id);

  List<MechanicView> findMechanicByQualificationAndGarageId(String qualification, Long id);
}
