package org.laicose.logitrack.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.laicose.logitrack.model.LigneCommande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {

    @Query("select sum(l.quantite * l.produit.prix) from LigneCommande l where l.commande.client.id =:id")
    Double totalImpaye(@Param("id") long id);

    @Query("SELECT lc FROM LigneCommande lc WHERE lc.commande.client.id = :id")
    Page<LigneCommande> getallCommande(@Param("id") long id, Pageable pageable);
}
