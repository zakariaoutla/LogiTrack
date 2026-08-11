package org.laicose.logitrack.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.laicose.logitrack.Enum.CommandeStatut;
import org.laicose.logitrack.dto.request.CommandeReqDto;
import org.laicose.logitrack.dto.response.CommandeResDto;
import org.laicose.logitrack.dto.response.OrderStatusStatsDto;
import org.laicose.logitrack.model.Commande;
import org.laicose.logitrack.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<Page<CommandeResDto>> getAll(@PageableDefault(page = 0,size=10, direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(commandeService.getAllCommandes(pageable));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public ResponseEntity<CommandeResDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(commandeService.getById(id));
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

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','AGENT')")
    @GetMapping("/total-commande-client/{id}")
    public ResponseEntity<Long> getCommandeClient(@PathVariable long id){
        return ResponseEntity.ok(commandeService.getTotalCommandeClient(id));

    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','AGENT')")
    @GetMapping("/count-status")
     public ResponseEntity<OrderStatusStatsDto> getCountByStatus(){
        return ResponseEntity.ok(commandeService.countByStatus());
    }

}
