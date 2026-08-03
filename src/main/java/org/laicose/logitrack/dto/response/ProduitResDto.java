package org.laicose.logitrack.dto.response;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProduitResDto implements Serializable {

    private long id;
    private String nom;
    private String categorie;
    private double prix;
    private int quantiteStock;
}
