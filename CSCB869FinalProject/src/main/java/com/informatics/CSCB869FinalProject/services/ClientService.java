package com.informatics.CSCB869FinalProject.services;

import com.informatics.CSCB869FinalProject.data.entity.Client;
import com.informatics.CSCB869FinalProject.web.view.ClientView;

import java.util.List;


public interface ClientService
{
  Client create(Client addNewClient);

  Client updateClient(Long id, Client updateClient);

  void deleteClient(Long id);

  List<ClientView> findAllClientsByGarageId(Long id);

}
