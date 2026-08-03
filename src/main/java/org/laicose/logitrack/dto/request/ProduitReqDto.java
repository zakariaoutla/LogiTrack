package org.laicose.logitrack.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProduitReqDto {

    @NotBlank(message = "Le nom du produit ne peut pas être vide")
    @Size(min = 2, max = 100, message = "Le nom doit contenir entre 2 et 100 caractères")
    private String nom;
    @NotBlank(message = "La catégorie ne peut pas être vide")
    private String categorie;

    @Positive(message = "Le prix doit être strictement supérieur à zéro")
    private double prix;
    @Min(value = 0, message = "La quantité en stock ne peut pas être négative")
    private int quantiteStock;
}
