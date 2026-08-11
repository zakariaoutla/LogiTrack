package org.laicose.logitrack.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.laicose.logitrack.Enum.CommandeStatut;
import org.laicose.logitrack.model.Client;
import org.laicose.logitrack.model.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

    @Query("SELECT count(c) from Commande c WHERE c.client.id=:id")
    long totalCommandeClient(@Param("id") long id);

    @Query("SELECT count(0) from Commande")
    long totalCommend();

    long countByCommandeStatut(CommandeStatut statut);

}
