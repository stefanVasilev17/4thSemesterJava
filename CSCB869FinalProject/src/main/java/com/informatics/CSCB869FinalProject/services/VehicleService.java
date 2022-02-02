package com.informatics.CSCB869FinalProject.services;

import com.informatics.CSCB869FinalProject.data.entity.Vehicle;
import com.informatics.CSCB869FinalProject.web.view.VehicleInfoView;

import java.math.BigDecimal;
import java.util.List;

public interface VehicleService
{
  Vehicle create(Vehicle vehicle);

  void fixVehicle(Long id, BigDecimal amountOfMoney);

  void deleteVehicle(Long id);

  List<VehicleInfoView> findAllVehiclesByClientId(Long id);
}
