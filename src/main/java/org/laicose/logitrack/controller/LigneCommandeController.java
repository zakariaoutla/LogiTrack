package org.laicose.logitrack.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.laicose.logitrack.dto.request.LigneCommandeReqDto;
import org.laicose.logitrack.dto.response.LigneCommandeResDto;
import org.laicose.logitrack.service.LigneCommandeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class LigneCommandeController {

    private final LigneCommandeService ligneCommandeService;

    @PostMapping("/{orderId}/products")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LigneCommandeResDto> ajouteCommande(
            @PathVariable long orderId,
            @Valid @RequestBody LigneCommandeReqDto request) {
        request.setCommandeId(orderId);

        LigneCommandeResDto savedLigne = ligneCommandeService.ajouteUnProduit(request);

        return new ResponseEntity<>(savedLigne, HttpStatus.CREATED);
    }

    @DeleteMapping("/products/{ligneId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteLigne(@PathVariable long ligneId) {
        ligneCommandeService.deleteLigne(ligneId);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/total-impaye/{id}")
    public ResponseEntity<Double> totalImpaye(@PathVariable long id){
      return ResponseEntity.ok(ligneCommandeService.totalImpaye(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/commande/{id}")
    public ResponseEntity<Page<LigneCommandeResDto>> getAllCommandeByClient(@PathVariable long id,
                                                                            @PageableDefault(page =0,size=10, direction = Sort.Direction.ASC)Pageable pageable){
        return ResponseEntity.ok(ligneCommandeService.getAllLigneCommande(id, pageable));
    }

}
