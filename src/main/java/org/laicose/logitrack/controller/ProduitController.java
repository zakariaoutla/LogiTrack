package org.laicose.logitrack.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.laicose.logitrack.dto.request.ProduitReqDto;
import org.laicose.logitrack.dto.response.ProduitResDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.laicose.logitrack.model.Produit;
import org.laicose.logitrack.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/produit")
public class ProduitController {

    private final ProduitService produitService;


    @GetMapping
    public ResponseEntity<List<ProduitResDto>> getAll() {
        return ResponseEntity.ok(produitService.getAllProduits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitResDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(produitService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProduitResDto> save(@Valid @RequestBody ProduitReqDto produitReqDto) {
        ProduitResDto savedProduit = produitService.save(produitReqDto);
        return new ResponseEntity<>(savedProduit, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProduitResDto> update(@PathVariable long id, @Valid @RequestBody ProduitReqDto produitReqDto) {
        return ResponseEntity.ok(produitService.update(id, produitReqDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        produitService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categorie/{categorie}")
    public ResponseEntity<List<ProduitResDto>> getByCategorie(@PathVariable String categorie) {
        return ResponseEntity.ok(produitService.findByCategorie(categorie));
    }

    @GetMapping("/prix-max")
    public ResponseEntity<List<ProduitResDto>> getByPrixLessThan(@RequestParam double prix) {
        return ResponseEntity.ok(produitService.findByPrixLessThan(prix));
    }

    @GetMapping("/stock-bas")
    public ResponseEntity<List<ProduitResDto>> getLowStock() {
        return ResponseEntity.ok(produitService.findLowStock());
    }

    @GetMapping("/top")
    public ResponseEntity<ProduitResDto> getTopProduit() {
        return ResponseEntity.ok(produitService.findTopProduit());
    }

    @GetMapping("/recherche")
    public ResponseEntity<ProduitResDto> getByNom(@RequestParam String nom) {
        return ResponseEntity.ok(produitService.findByNom(nom));
    }
}
