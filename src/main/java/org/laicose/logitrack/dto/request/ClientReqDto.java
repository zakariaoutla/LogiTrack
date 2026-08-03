package org.laicose.logitrack.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientReqDto {

    @NotBlank(message = "Le nom ne peut pas être vide")
    @Size(min = 2, max = 50, message = "Le nom doit contenir entre 2 et 50 caractères")
    private String nom;
    @NotBlank(message = "L'email ne peut pas être vide")
    @Email(message = "Le format de l'email est invalide")
    private String email;
    @NotBlank(message = "Le numéro de téléphone ne peut pas être vide")
    private String telephone;
    @NotBlank(message = "La ville ne peut pas être vide")
    private String ville;
}
