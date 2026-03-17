package org.laicose.logitrack.controller;


import org.laicose.logitrack.model.Client;
import org.laicose.logitrack.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClient(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable long id){
        return clientService.getById(id);
    }


    @PostMapping
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id){
        clientService.delete(id);
    }
}
