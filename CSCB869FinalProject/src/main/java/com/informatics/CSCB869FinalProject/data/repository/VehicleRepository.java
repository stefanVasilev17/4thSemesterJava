package com.informatics.CSCB869FinalProject.data.repository;

import com.informatics.CSCB869FinalProject.data.entity.Vehicle;
import com.informatics.CSCB869FinalProject.web.view.VehicleInfoView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>
{
  List<Vehicle> findAllVehiclesByClientId(Long id);

  List<Vehicle> findVehicleByLicensePlate(String licensePlate);
}
