package org.laicose.logitrack.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.laicose.logitrack.model.Produit;
import org.laicose.logitrack.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produit")
public class ProduitController {

    @Autowired
    private ProduitService produitService;


    @GetMapping
    public List<Produit> getAllProduit(){
        return produitService.getAllProduit();
    }

    @GetMapping("/{id}")
    public Produit getById(@PathVariable long id){
        return produitService.getById(id);
    }

    @PostMapping
    public Produit save(@RequestBody Produit produit){
        return produitService.save(produit);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id){
        produitService.delete(id);
    }
}
