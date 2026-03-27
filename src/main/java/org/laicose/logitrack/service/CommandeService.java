package org.laicose.logitrack.service;


import org.laicose.logitrack.model.Client;
import org.laicose.logitrack.model.Commande;
import org.laicose.logitrack.model.Produit;
import org.laicose.logitrack.repository.ClientRepository;
import org.laicose.logitrack.repository.CommandeRepository;
import org.laicose.logitrack.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Transactional
    public Commande creeCommende(long clientId){
        Client client = clientRepository.findById(clientId).orElse(null);
        Commande commande = new Commande();
        commande.setClient(client);
        
        commande.setDateCommande(LocalDate.now());
        commande.setStatut("EN_ATTENTE");
        return commandeRepository.save(commande);
    }

    public List<Commande> getAllCommande(){
        return commandeRepository.findAll();
    }

    public Commande getByid(long id){
        return commandeRepository.findById(id).orElse(null);
    }

    public List<Commande> findClientById(long clientId){
        return commandeRepository.findClientById(clientId);
    }

    public long countTotalCommend(){
        return commandeRepository.totalCommend();
    }

    public Commande update(long id, String newStatut){
        Commande commande = getByid(id);
        commande.setStatut(newStatut);
        return commandeRepository.save(commande);
    }


}
