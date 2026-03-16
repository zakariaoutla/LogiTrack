package org.laicose.logitrack.service;


import org.laicose.logitrack.model.Client;
import org.laicose.logitrack.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;


    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getById(long id){
        return clientRepository.findById(id).orElse(null);
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public void delete(long id){
         clientRepository.deleteById(id);
    }
}
