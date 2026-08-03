package org.laicose.logitrack.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ligne_commande")
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantite;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;
}
