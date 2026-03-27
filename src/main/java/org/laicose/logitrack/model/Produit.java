package org.laicose.logitrack.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String categorie;
    private double prix;

    @Column(name = "quantite")
    private int quantiteStock;

    @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private List<LigneCommande> ligneCommandes;

}
