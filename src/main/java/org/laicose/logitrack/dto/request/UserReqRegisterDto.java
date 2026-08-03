package org.laicose.logitrack.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.laicose.logitrack.Enum.RoleUser;

@Getter
@Setter
public class UserReqRegisterDto {
    @NotBlank(message = "nom est obligatoire")
    private String nom;
    @NotBlank(message = "prenom est obligatoire")
    private String prenom;
    @NotBlank(message = "email est obligatoire")
    private String email;
    @NotBlank(message = "password est obligatoire")
    private String password ;
    @NotBlank(message = "role est obligatoire")
    private RoleUser RoleUser;
}
