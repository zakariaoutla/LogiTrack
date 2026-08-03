package org.laicose.logitrack.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReqLogin {
    @NotBlank(message = "email est obligatoire")
    private String email;
    @NotBlank(message = "password est obligatoire")
    private String password ;
}
