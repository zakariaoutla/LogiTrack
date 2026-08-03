package org.laicose.logitrack.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.laicose.logitrack.dto.request.ClientReqDto;
import org.laicose.logitrack.dto.response.ClientResDto;
import org.laicose.logitrack.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
public class ClientController {


    private final ClientService clientService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','AGENT')")
    public ResponseEntity<List<ClientResDto>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public ResponseEntity<ClientResDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(clientService.getById(id));
    }


    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public ResponseEntity<ClientResDto> save(@Valid @RequestBody ClientReqDto clientReqDto) {
        ClientResDto savedClient = clientService.save(clientReqDto);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public ResponseEntity<ClientResDto> update(@PathVariable long id, @Valid @RequestBody ClientReqDto clientReqDto) {
        return ResponseEntity.ok(clientService.update(id, clientReqDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
