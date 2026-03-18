package org.laicose.logitrack.controller;

import org.laicose.logitrack.model.Commande;
import org.laicose.logitrack.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commande")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;


    @GetMapping
    public List<Commande> getAll(){
        return commandeService.getAllCommande();
    }

    @GetMapping("{id}")
    public Commande getById(@PathVariable long id){
        return commandeService.getByid(id);
    }
    @GetMapping("/totalcommand/{id}")
        public List<Commande>  getClientById(@PathVariable long id){
         return commandeService.findClientById(id);
        }

    @GetMapping("/count")
    public long getCountTotalCommend(){
        return commandeService.countTotalCommend();
    }

    @PostMapping
    public Commande creeCommende(@RequestParam  long clientId){
        return commandeService.creeCommende(clientId);
    }

    @PutMapping("{id}")
    public Commande update(@PathVariable long id, @RequestBody String newStatut){
        return commandeService.update(id, newStatut);
    }


}
