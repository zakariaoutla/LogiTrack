package org.laicose.logitrack.controller;

import org.laicose.logitrack.model.LigneCommande;
import org.laicose.logitrack.service.LigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class LigneCommandeController {

    @Autowired
    private LigneCommandeService ligneCommandeService;

    @PostMapping("/{orderId}/products")
    public LigneCommande ajouteCommande(@PathVariable long orderId, @RequestParam long produitId, @RequestParam int quantite){
        return ligneCommandeService.ajouteUnProduit(orderId, produitId,quantite);

    }

}
