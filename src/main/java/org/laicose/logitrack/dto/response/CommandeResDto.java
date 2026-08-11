package org.laicose.logitrack.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.laicose.logitrack.Enum.CommandeStatut;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class CommandeResDto implements Serializable {

    private long id;
    private LocalDate dateCommande;
    private CommandeStatut commandeStatut;
    private long clientId;
    private String clientNom;
}
