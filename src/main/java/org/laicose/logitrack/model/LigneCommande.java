package org.laicose.logitrack.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;
}
