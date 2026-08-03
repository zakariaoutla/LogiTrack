package org.laicose.logitrack.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.laicose.logitrack.dto.request.LigneCommandeReqDto;
import org.laicose.logitrack.dto.response.LigneCommandeResDto;
import org.laicose.logitrack.model.LigneCommande;
import org.laicose.logitrack.service.LigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class LigneCommandeController {

    private final LigneCommandeService ligneCommandeService;

    @PostMapping("/{orderId}/products")
    public ResponseEntity<LigneCommandeResDto> ajouteCommande(
            @PathVariable long orderId,
            @Valid @RequestBody LigneCommandeReqDto request) {
        request.setCommandeId(orderId);

        LigneCommandeResDto savedLigne = ligneCommandeService.ajouteUnProduit(request);

        return new ResponseEntity<>(savedLigne, HttpStatus.CREATED);
    }

    @DeleteMapping("/products/{ligneId}")
    public ResponseEntity<Void> deleteLigne(@PathVariable long ligneId) {
        ligneCommandeService.deleteLigne(ligneId);
        return ResponseEntity.noContent().build();
    }

}
