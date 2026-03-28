package org.laicose.logitrack.repository;

import org.laicose.logitrack.model.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {

}
