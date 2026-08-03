package org.laicose.logitrack.mapper;

import org.laicose.logitrack.dto.request.ProduitReqDto;
import org.laicose.logitrack.dto.response.ProduitResDto;
import org.laicose.logitrack.model.Produit;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProduitMapper {

    Produit toEntity(ProduitReqDto produitReqDto);

    List<ProduitResDto> toListDto(List<Produit> produits);

    ProduitResDto toResponse(Produit produit);

    void updateEntityFromDto(ProduitReqDto dto, @MappingTarget Produit entity);

}
