package org.laicose.logitrack.service;


import lombok.RequiredArgsConstructor;
import org.laicose.logitrack.dto.request.LigneCommandeReqDto;
import org.laicose.logitrack.dto.response.LigneCommandeResDto;
import org.laicose.logitrack.mapper.LigneCommandeMapper;
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
@RequiredArgsConstructor
public class LigneCommandeService {


    private final LigneCommandeRepository ligneCommandeRepository;
    private final ProduitRepository produitRepository;
    private final CommandeRepository commandeRepository;
    private final LigneCommandeMapper ligneCommandeMapper;


    @Transactional
    public LigneCommandeResDto ajouteUnProduit(LigneCommandeReqDto request) {
        Commande commande = commandeRepository.findById(request.getCommandeId())
                .orElseThrow(() -> new RuntimeException("Commande avec l'ID " + request.getCommandeId() + " introuvable"));

        Produit produit = produitRepository.findById(request.getProduitId())
                .orElseThrow(() -> new RuntimeException("Produit avec l'ID " + request.getProduitId() + " introuvable"));

        if (produit.getQuantiteStock() < request.getQuantite()) {
            throw new RuntimeException("Stock insuffisant pour : " + produit.getNom());
        }

        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setCommande(commande);
        ligneCommande.setProduit(produit);
        ligneCommande.setQuantite(request.getQuantite());

        produit.setQuantiteStock(produit.getQuantiteStock() - request.getQuantite());
        produitRepository.save(produit);

        LigneCommande savedLigne = ligneCommandeRepository.save(ligneCommande);
        return ligneCommandeMapper.toResponseDto(savedLigne);
    }


    @Transactional
    public void deleteLigne(long id) {
        LigneCommande ligne = ligneCommandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ligne de commande introuvable"));

        Produit produit = ligne.getProduit();
        produit.setQuantiteStock(produit.getQuantiteStock() + ligne.getQuantite());
        produitRepository.save(produit);

        ligneCommandeRepository.delete(ligne);
    }



}
