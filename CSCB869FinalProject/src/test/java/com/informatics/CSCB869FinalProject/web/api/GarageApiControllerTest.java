package com.informatics.CSCB869FinalProject.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.informatics.CSCB869FinalProject.data.entity.Garage;
import com.informatics.CSCB869FinalProject.data.entity.Mechanic;
import com.informatics.CSCB869FinalProject.data.repository.GarageRepository;
import com.informatics.CSCB869FinalProject.services.GarageService;
import com.informatics.CSCB869FinalProject.services.MechanicService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(GarageApiController.class)
public class GarageApiControllerTest
{

  @MockBean
  private MechanicService mechanicService;

  @MockBean
  private GarageRepository garageRepository;

  @MockBean
  private GarageService garageService;

  @MockBean
  private ModelMapper modelMapper;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void createGarage() throws Exception
  {
    long garageId = 1;
    Garage garage = new Garage();
    garage.setId(garageId);
    garage.setName("Stefan's garage");
    garage.setKindOfServices("FULL EXPERIENCE");
    garage.setDayBudget(BigDecimal.valueOf(200));

    when(garageService.create(any(Garage.class))).thenReturn(garage);

    mockMvc.perform(MockMvcRequestBuilders.post("/api/garages/create-garage")
        .content(objectMapper.writeValueAsString(garage))
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(jsonPath(".kindOfServices").value("FULL EXPERIENCE"))
        .andExpect(status().isOk());
  }

  @Test
  void updateGarage() throws Exception
  {
    long garageId2 = 1;
    Garage garageBeforeUpdate = new Garage();
    garageBeforeUpdate.setId(garageId2);
    garageBeforeUpdate.setName("Selfie garage");
    garageBeforeUpdate.setKindOfServices("FULL EXPERIENCE");
    garageBeforeUpdate.setDayBudget(BigDecimal.valueOf(200));

    when(garageService.create(garageBeforeUpdate)).thenReturn(garageBeforeUpdate);

    Garage updatedGarage = new Garage();
    updatedGarage.setId(garageId2);
    updatedGarage.setName("LALALLALALA garage");
    updatedGarage.setKindOfServices("FULL EXPERIENCE");
    updatedGarage.setDayBudget(BigDecimal.valueOf(850));


    mockMvc.perform(MockMvcRequestBuilders.put("/api/garages/update-garage/{id}", garageId2)
        .content(objectMapper.writeValueAsString(updatedGarage))
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void deleteGarage() throws Exception
  {
    long garageId = 1;
    Garage garage = new Garage();
    garage.setId(garageId);
    garage.setName("Stefan's garage");
    garage.setKindOfServices("FULL EXPERIENCE");
    garage.setDayBudget(BigDecimal.valueOf(200));

    when(garageService.create(any(Garage.class))).thenReturn(garage);

    mockMvc.perform(MockMvcRequestBuilders.delete("/api/garages/delete-garage/{id}", "1"))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void getAllGarages() throws Exception
  {
    long garageId = 1;
    Garage garage = new Garage();
    garage.setId(garageId);
    garage.setName("Stefan's garage");
    garage.setKindOfServices("FULL EXPERIENCE");
    garage.setDayBudget(BigDecimal.valueOf(200));
    List<Garage> allGarages = new ArrayList<>();
    allGarages.add(garage);
    when(garageService.getGarages()).thenReturn(allGarages);

    mockMvc.perform(MockMvcRequestBuilders.get("/api/garages"))
        .andExpect(jsonPath("[*].kindOfServices", hasItems("FULL EXPERIENCE")))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void getAllMechanicsByGarageId() throws Exception
  {
    long garageId = 1;
    Garage garage = new Garage();
    garage.setId(garageId);
    garage.setName("Stefan's garage");
    garage.setKindOfServices("FULL EXPERIENCE");
    garage.setDayBudget(BigDecimal.valueOf(200));
    List<Garage> allGarages = new ArrayList<>();
    allGarages.add(garage);
    when(garageService.getGarages()).thenReturn(allGarages);

    mockMvc.perform(MockMvcRequestBuilders.get("/api/garages/get-mechanics-by-garage-id/{id}", 1))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void hireMechanic() throws Exception
  {
    long garageId = 1;
    Mechanic mechanic = new Mechanic();
    mechanic.setId(garageId);
    mechanic.setSalary(BigDecimal.valueOf(2500));
    mechanic.setQualification("LIGHT");
    mechanic.setTypeOfMechanic("NEWBIE");
    mechanic.setSpecializedCarBrand("MERCEDES-BENZ");
    when(mechanicService.hireMechanic(mechanic)).thenReturn(mechanic);

    mockMvc.perform(MockMvcRequestBuilders.post("/api/garages/hire-mechanic", 1)
        .content(objectMapper.writeValueAsString(mechanic))
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void fireMechanic() throws Exception
  {
    long garageId = 1;
    Mechanic mechanic = new Mechanic();
    mechanic.setId(garageId);
    mechanic.setSalary(BigDecimal.valueOf(2500));
    mechanic.setQualification("LIGHT");
    mechanic.setTypeOfMechanic("NEWBIE");
    mechanic.setSpecializedCarBrand("MERCEDES-BENZ");
    when(mechanicService.hireMechanic(mechanic)).thenReturn(mechanic);

    mockMvc.perform(MockMvcRequestBuilders.delete("/api/garages/fire-mechanic/{id}", 1)
        .content(objectMapper.writeValueAsString(mechanic))
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());
  }
}
