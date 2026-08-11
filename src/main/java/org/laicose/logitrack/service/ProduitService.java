package org.laicose.logitrack.service;

import lombok.RequiredArgsConstructor;
import org.laicose.logitrack.dto.request.ProduitReqDto;
import org.laicose.logitrack.dto.response.ProduitResDto;
import org.laicose.logitrack.mapper.ProduitMapper;
import org.laicose.logitrack.model.Produit;
import org.laicose.logitrack.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitService {

    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;


    public Page<ProduitResDto> getAllProduits(Pageable pageable) {
        Page<Produit> produits = produitRepository.findAll(pageable);
        return produits.map(produitMapper::toResponse);
    }

    public ProduitResDto getById(long id) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit avec l'ID " + id + " est introuvable"));
        return produitMapper.toResponse(produit);
    }

    public ProduitResDto save(ProduitReqDto request) {
        Produit produit = produitMapper.toEntity(request);
        Produit savedProduit = produitRepository.save(produit);
        return produitMapper.toResponse(savedProduit);
    }
    public ProduitResDto update(long id, ProduitReqDto request) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit avec l'ID " + id + " est introuvable"));

        produitMapper.updateEntityFromDto(request, produit);

        Produit updatedProduit = produitRepository.save(produit);
        return produitMapper.toResponse(updatedProduit);
    }


    public void delete(long id) {
        if (!produitRepository.existsById(id)) {
            throw new RuntimeException("Produit avec l'ID " + id + " est introuvable");
        }
        produitRepository.deleteById(id);
    }

    public List<ProduitResDto> findByCategorie(String categorie) {
        List<Produit> produits = produitRepository.findByCategorie(categorie);
        return produitMapper.toListDto(produits);
    }

    public List<ProduitResDto> findByPrixLessThan(double prix) {
        List<Produit> produits = produitRepository.findByPrixLessThan(prix);
        return produitMapper.toListDto(produits);
    }

    public List<ProduitResDto> findLowStock() {
        List<Produit> produits = produitRepository.findLowStockProduits();
        return produitMapper.toListDto(produits);
    }

    public ProduitResDto findTopProduit() {
        Produit produit = produitRepository.findTopProduit();
        if (produit == null) {
            throw new RuntimeException("Aucun produit trouvé");
        }
        return produitMapper.toResponse(produit);
    }

    public ProduitResDto findByNom(String nom) {
        Produit produit = produitRepository.findByNom(nom);
        if (produit == null) {
            throw new RuntimeException("Produit avec le nom '" + nom + "' est introuvable");
        }
        return produitMapper.toResponse(produit);
    }

    public Long getCountProduit(){
        return produitRepository.count();
    }
}
