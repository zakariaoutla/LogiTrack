package org.laicose.logitrack.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.laicose.logitrack.Enum.CommandeStatut;

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
    @Column(name = "date_commande")
    private LocalDate dateCommande;
    @Column(name = "commande_statut")
    @Enumerated(EnumType.STRING)
    private CommandeStatut commandeStatut;


    @JsonIgnore
    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> ligneCommandes;

    @ManyToOne
    private Client client;
}
