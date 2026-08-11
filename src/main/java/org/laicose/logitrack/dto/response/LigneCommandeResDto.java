package org.laicose.logitrack.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.laicose.logitrack.Enum.CommandeStatut;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class LigneCommandeResDto implements Serializable {

    private long id;
    private int quantite;
    private long commandeId;
    private long produitId;
    private String produitNom;
    private Double montantTotal;
    private LocalDate dateCommande;
    private CommandeStatut commandeStatut;




}
