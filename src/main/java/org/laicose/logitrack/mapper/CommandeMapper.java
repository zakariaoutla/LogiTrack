package org.laicose.logitrack.mapper;


import org.laicose.logitrack.dto.request.CommandeReqDto;
import org.laicose.logitrack.dto.response.CommandeResDto;
import org.laicose.logitrack.model.Commande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommandeMapper {

    @Mapping(source = "clientId", target = "client.id")
    Commande toEntity(CommandeReqDto commandeReqDto);

    List<CommandeResDto> toListDto(List<Commande> commandes);

    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "client.nom", target = "clientNom")
    CommandeResDto toResponse(Commande commande);
}
