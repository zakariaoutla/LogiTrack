package org.laicose.logitrack.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LigneCommandeResDto implements Serializable {

    private long id;
    private int quantite;
    private long commandeId;
    private long produitId;
}
