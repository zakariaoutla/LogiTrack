package org.laicose.logitrack.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.laicose.logitrack.Enum.CommandeStatut;

import java.time.LocalDate;

@Getter
@Setter
public class CommandeReqDto {

    @NotNull(message = "La date de commande est obligatoire")
    @PastOrPresent(message = "La date de commande ne peut pas être dans le futur")
    private LocalDate dateCommande;
    @NotNull(message = "Le statut de la commande est obligatoire")
    private CommandeStatut commandeStatut;
    @NotNull(message = "Client est obligatoire")
    private long clientId;
}
