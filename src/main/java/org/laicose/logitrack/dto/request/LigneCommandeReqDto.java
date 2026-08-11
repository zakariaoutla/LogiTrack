package org.laicose.logitrack.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LigneCommandeReqDto {

    @Positive(message = "La quantité doit être supérieure à zéro")
    private int quantite;
    @NotNull(message = "Commande est obligatoire")
    private Long commandeId;
    @NotNull(message = "Produit est obligatoire")
    private Long produitId;

}
