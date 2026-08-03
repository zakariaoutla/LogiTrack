package org.laicose.logitrack.mapper;


import org.laicose.logitrack.dto.request.LigneCommandeReqDto;
import org.laicose.logitrack.dto.response.LigneCommandeResDto;
import org.laicose.logitrack.model.LigneCommande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LigneCommandeMapper {

    @Mapping(source = "commandeId", target = "commande.id")
    @Mapping(source = "produitId", target = "produit.id")
    LigneCommande toEntity(LigneCommandeReqDto ligneCommandeReqDto);

    List<LigneCommandeReqDto> toListDto(List<LigneCommande> ligneCommandes);

    @Mapping(source = "commande.id", target = "commandeId")
    @Mapping(source = "produit.id", target = "produitId")
    LigneCommandeResDto toResponseDto(LigneCommande ligneCommande);
}
