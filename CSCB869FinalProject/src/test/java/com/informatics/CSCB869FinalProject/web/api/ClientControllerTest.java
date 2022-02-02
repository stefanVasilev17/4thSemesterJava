package com.informatics.CSCB869FinalProject.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.informatics.CSCB869FinalProject.data.entity.Client;
import com.informatics.CSCB869FinalProject.data.entity.Garage;
import com.informatics.CSCB869FinalProject.data.entity.Mechanic;
import com.informatics.CSCB869FinalProject.data.entity.Vehicle;
import com.informatics.CSCB869FinalProject.services.ClientService;
import com.informatics.CSCB869FinalProject.services.MechanicService;
import com.informatics.CSCB869FinalProject.services.VehicleService;
import com.informatics.CSCB869FinalProject.web.view.MechanicView;
import com.informatics.CSCB869FinalProject.web.view.VehicleInfoView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(ClientController.class)
public class ClientControllerTest
{
  @MockBean
  private ClientService clientService;

  @MockBean
  private VehicleService vehicleService;

  @MockBean
  private MechanicService mechanicService;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void createClient() throws Exception
  {
    long clientId = 1;
    Client client = new Client();
    client.setName("Stefan");
    client.setSurname("Vasilev");
    client.setTelephoneNumber("0888775566");
    client.setId(clientId);
    client.setBudget(BigDecimal.valueOf(700));

    when(clientService.create(any(Client.class))).thenReturn(client);

    mockMvc.perform(MockMvcRequestBuilders.post("/api/clients/add-new-client")
        .content(objectMapper.writeValueAsString(client))
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(jsonPath(".name").value("Stefan"))
        .andExpect(jsonPath(".surname").value("Vasilev"))
        .andExpect(status().isOk());
  }

  @Test
  void updateClient() throws Exception
  {
    long clientId = 1;
    Client client = new Client();
    client.setName("Stefan");
    client.setSurname("Vasilev");
    client.setTelephoneNumber("0888775566");
    client.setId(clientId);
    client.setBudget(BigDecimal.valueOf(700));

    when(clientService.updateClient(1L, client)).thenReturn(client);

    mockMvc.perform(MockMvcRequestBuilders.put("/api/clients/update-client/{id}", 1)
        .content(objectMapper.writeValueAsString(client))
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void deleteClient() throws Exception
  {
    long clientId = 1;
    Client client = new Client();
    client.setName("Stefan");
    client.setSurname("Vasilev");
    client.setTelephoneNumber("0888775566");
    client.setId(clientId);
    client.setBudget(BigDecimal.valueOf(700));

    when(clientService.create(any(Client.class))).thenReturn(client);

    mockMvc.perform(MockMvcRequestBuilders.delete("/api/clients/delete-client/{id}", 1)
        .content(objectMapper.writeValueAsString(client))
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void findAllVehiclesByClientId() throws Exception
  {
    long clientId = 1;
    Client client = new Client();
    client.setName("Stefan");
    client.setSurname("Vasilev");
    client.setTelephoneNumber("0888775566");
    client.setId(clientId);
    client.setBudget(BigDecimal.valueOf(700));

    VehicleInfoView vehicleInfoView = new VehicleInfoView();
    vehicleInfoView.setLicensePlate("A5511VR");
    vehicleInfoView.setHorsePower(204L);
    vehicleInfoView.setPetrol("DIESEL");

    List<VehicleInfoView> allVehs = new ArrayList<>();
    allVehs.add(vehicleInfoView);

    when(vehicleService.findAllVehiclesByClientId(1L)).thenReturn(allVehs);

    mockMvc.perform(MockMvcRequestBuilders.get("/api/clients/find-all-vehicles-by-client-id/{id}", 1))
        .andExpect(jsonPath("[*].licensePlate", hasItems("A5511VR")))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void createVehicle() throws Exception
  {
    long clientId = 1;
    Vehicle vehicle = new Vehicle();
    vehicle.setId(clientId);
    vehicle.setBrand("PEUGEOT");
    vehicle.setDrive("FRONT");
    vehicle.setLitres("1600");
    vehicle.setPetrol("DIESEL");
    vehicle.setDriverComplaints("ENGINE");

    when(vehicleService.create(any(Vehicle.class))).thenReturn(vehicle);

    mockMvc.perform(MockMvcRequestBuilders.post("/api/clients/add-new-vehicle")
        .content(objectMapper.writeValueAsString(vehicle))
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(jsonPath(".brand").value("PEUGEOT"))
        .andExpect(jsonPath(".petrol").value("DIESEL"))
        .andExpect(status().isOk());
  }

  @Test
  void deleteVehicle() throws Exception
  {
    long clientId = 1;
    Vehicle vehicle = new Vehicle();
    vehicle.setId(clientId);
    vehicle.setBrand("PEUGEOT");
    vehicle.setDrive("FRONT");
    vehicle.setLitres("1600");
    vehicle.setPetrol("DIESEL");
    vehicle.setDriverComplaints("ENGINE");

    when(vehicleService.create(any(Vehicle.class))).thenReturn(vehicle);

    mockMvc.perform(MockMvcRequestBuilders.delete("/api/clients/delete-vehicle/{id}", 1)
        .content(objectMapper.writeValueAsString(vehicle))
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void fixVehicle() throws Exception
  {
    long clientId = 1;
    Vehicle vehicle = new Vehicle();
    vehicle.setId(clientId);
    vehicle.setBrand("PEUGEOT");
    vehicle.setDrive("FRONT");
    vehicle.setLitres("1600");
    vehicle.setPetrol("DIESEL");
    vehicle.setDriverComplaints("ENGINE");

    when(vehicleService.create(any(Vehicle.class))).thenReturn(vehicle);

    mockMvc.perform(MockMvcRequestBuilders.patch("/api/clients/fix-vehicle/{id}/{amount}", 1, 30)
        .content(objectMapper.writeValueAsString(vehicle))
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void getMechanicsByQualificationAndByGarageId() throws Exception
  {
    long mechId = 1;
    MechanicView mechanic = new MechanicView();
    mechanic.setId(mechId);
    mechanic.setName("Kiril");
    mechanic.setSurname("Vasilev");
    mechanic.setQualification("LIGHT");

    List<MechanicView> mechanicViewList = new ArrayList<>();
    mechanicViewList.add(mechanic);

    when(mechanicService.findMechanicByQualificationAndGarageId("LIGHT", 1L)).thenReturn(mechanicViewList);

    mockMvc.perform(MockMvcRequestBuilders.get("/api/clients/find-all-vehicles-by-client-id/{id}", 1))
        .andDo(print())
        .andExpect(status().isOk());
  }
}
