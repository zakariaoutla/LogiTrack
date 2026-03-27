package org.laicose.logitrack.service;


import org.laicose.logitrack.model.Commande;
import org.laicose.logitrack.model.LigneCommande;
import org.laicose.logitrack.model.Produit;
import org.laicose.logitrack.repository.CommandeRepository;
import org.laicose.logitrack.repository.LigneCommandeRepository;
import org.laicose.logitrack.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LigneCommandeService {


   @Autowired
    LigneCommandeRepository ligneCommandeRepository;
   @Autowired
    ProduitRepository produitRepository;
   @Autowired
    CommandeRepository commandeRepository;

    @Transactional
    public LigneCommande ajouteUnProduit(long commandeId, long productId, int quantite){
        Commande commande = commandeRepository.findById(commandeId).orElse(null);

        Produit produit = produitRepository.findById(productId).orElse(null);

        if (produit.getQuantiteStock()< quantite){
            throw new RuntimeException("Stock insuffisant pour : " + produit.getNom());
        }

        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setCommande(commande);
        ligneCommande.setProduit(produit);
        ligneCommande.setQuantite(quantite);

        produit.setQuantiteStock(produit.getQuantiteStock()- quantite);

        produitRepository.save(produit);

        return ligneCommandeRepository.save(ligneCommande);

   }



}
