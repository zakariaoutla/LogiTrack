package org.laicose.logitrack.service;


import lombok.RequiredArgsConstructor;
import org.laicose.logitrack.Enum.CommandeStatut;
import org.laicose.logitrack.dto.request.CommandeReqDto;
import org.laicose.logitrack.dto.response.CommandeResDto;
import org.laicose.logitrack.mapper.CommandeMapper;
import org.laicose.logitrack.model.Client;
import org.laicose.logitrack.model.Commande;
import org.laicose.logitrack.model.Produit;
import org.laicose.logitrack.repository.ClientRepository;
import org.laicose.logitrack.repository.CommandeRepository;
import org.laicose.logitrack.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    private final CommandeMapper commandeMapper;

    @Transactional
    public CommandeResDto creeCommande(CommandeReqDto request) {
        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new RuntimeException("Client avec l'ID " + request.getClientId() + " est introuvable"));

        Commande commande = commandeMapper.toEntity(request);
        commande.setClient(client);

        if (commande.getDateCommande() == null) {
            commande.setDateCommande(LocalDate.now());
        }

        Commande savedCommande = commandeRepository.save(commande);
        return commandeMapper.toResponse(savedCommande);
    }

    public List<CommandeResDto> getAllCommandes() {
        List<Commande> commandes = commandeRepository.findAll();
        return commandeMapper.toListDto(commandes);
    }

    public CommandeResDto getById(long id) {
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande avec l'ID " + id + " est introuvable"));
        return commandeMapper.toResponse(commande);
    }

    public List<CommandeResDto> getCommandesByClientId(long clientId) {
        List<Commande> commandes = commandeRepository.findByClientId(clientId);
        return commandeMapper.toListDto(commandes);
    }

    public long countTotalCommandes() {
        return commandeRepository.count();
    }
    public CommandeResDto updateStatut(long id, CommandeStatut newStatut) {
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande avec l'ID " + id + " est introuvable"));

        commande.setCommandeStatut(newStatut);
        Commande updatedCommande = commandeRepository.save(commande);

        return commandeMapper.toResponse(updatedCommande);
    }


}
