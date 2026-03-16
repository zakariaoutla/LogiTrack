package org.laicose.logitrack.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate dateCommande;
    private String statut;

    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> ligneCommandes;

    @ManyToOne
    private Client client;
}
