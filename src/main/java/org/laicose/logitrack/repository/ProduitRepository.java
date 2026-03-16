package org.laicose.logitrack.repository;

import org.laicose.logitrack.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
