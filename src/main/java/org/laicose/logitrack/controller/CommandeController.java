package org.laicose.logitrack.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.laicose.logitrack.Enum.CommandeStatut;
import org.laicose.logitrack.dto.request.CommandeReqDto;
import org.laicose.logitrack.dto.response.CommandeResDto;
import org.laicose.logitrack.model.Commande;
import org.laicose.logitrack.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/commande")
public class CommandeController {

    private final CommandeService commandeService;


    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','AGENT')")
    public ResponseEntity<List<CommandeResDto>> getAll() {
        return ResponseEntity.ok(commandeService.getAllCommandes());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public ResponseEntity<CommandeResDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(commandeService.getById(id));
    }

    @GetMapping("/client/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public ResponseEntity<List<CommandeResDto>> getClientById(@PathVariable long id) {
        return ResponseEntity.ok(commandeService.getCommandesByClientId(id));
    }

    @GetMapping("/total-commande")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public ResponseEntity<Long> getCountTotalCommandes() {
        return ResponseEntity.ok(commandeService.countTotalCommandes());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public ResponseEntity<CommandeResDto> creeCommande(@Valid @RequestBody CommandeReqDto request) {
        CommandeResDto savedCommande = commandeService.creeCommande(request);
        return new ResponseEntity<>(savedCommande, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/status")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','AGENT')")
    public ResponseEntity<CommandeResDto> updateStatut(@PathVariable long id, @RequestParam CommandeStatut newStatut) {
        return ResponseEntity.ok(commandeService.updateStatut(id, newStatut));
    }

}
