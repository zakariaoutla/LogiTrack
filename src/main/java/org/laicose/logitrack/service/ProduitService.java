package org.laicose.logitrack.service;

import org.laicose.logitrack.model.Produit;
import org.laicose.logitrack.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;


    public List<Produit> getAllProduit(){
        return produitRepository.findAll();
    }

    public Produit getById(long id){
        return produitRepository.findById(id).orElse(null);
    }

    public Produit save(Produit produit){
        return produitRepository.save(produit);
    }

    public void delete(long id){
        produitRepository.deleteById(id);
    }
}
