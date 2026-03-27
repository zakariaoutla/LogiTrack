package org.laicose.logitrack.repository;

import org.laicose.logitrack.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> findByCategorie(String categorie);

    List<Produit> findByPrixLessThan(double prix);

    @Query("SELECT p FROM Produit p WHERE p.quantiteStock < 10")
    List<Produit> findLowStockProduits();

    @Query("SELECT p FROM Produit p JOIN p.ligneCommandes lc GROUP BY p ORDER BY SUM(lc.quantite) DESC LIMIT 1")
    Produit findTopProduit();

}
