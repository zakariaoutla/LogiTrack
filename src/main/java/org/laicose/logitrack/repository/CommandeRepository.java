package org.laicose.logitrack.repository;

import org.laicose.logitrack.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
