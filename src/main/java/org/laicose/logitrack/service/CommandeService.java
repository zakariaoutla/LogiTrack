package org.laicose.logitrack.service;


import org.laicose.logitrack.model.Commande;
import org.laicose.logitrack.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public List<Commande> getAllCommande(){
        return commandeRepository.findAll();
    }

    public Commande getByid(long id){
        return commandeRepository.findById(id).orElse(null);
    }

    public Commande save(Commande commande){
        return commandeRepository.save(commande);
    }
}
