package org.laicose.logitrack.repository;

import org.laicose.logitrack.model.Client;
import org.laicose.logitrack.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

    List<Commande> findClientById(Long clintId);

    @Query("SELECT count(0) from Commande")
    long totalCommend();
}
