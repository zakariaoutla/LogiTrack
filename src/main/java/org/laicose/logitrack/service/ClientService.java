package org.laicose.logitrack.service;


import lombok.RequiredArgsConstructor;
import org.laicose.logitrack.dto.request.ClientReqDto;
import org.laicose.logitrack.dto.response.ClientResDto;
import org.laicose.logitrack.mapper.ClientMapper;
import org.laicose.logitrack.model.Client;
import org.laicose.logitrack.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public Page<ClientResDto> getAllClients(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(clientMapper::toResponseDto);
    }

    public ClientResDto getById(long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client avec l'ID " + id + " est introuvable"));
        return clientMapper.toResponseDto(client);
    }

    public ClientResDto save(ClientReqDto request) {
        Client client = clientMapper.toEntity(request);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toResponseDto(savedClient);
    }

    public ClientResDto update(long id, ClientReqDto request) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client avec l'ID " + id + " est introuvable"));
        client.setNom(request.getNom());
        client.setEmail(request.getEmail());
        client.setTelephone(request.getTelephone());
        client.setVille(request.getVille());

        Client updatedClient = clientRepository.save(client);
        return clientMapper.toResponseDto(updatedClient);
    }

    public void delete(long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client avec l'ID " + id + " est introuvable");
        }
        clientRepository.deleteById(id);
    }

    public long getTotalClient(){
        return clientRepository.count();
    }
}
