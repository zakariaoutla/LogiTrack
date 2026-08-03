package org.laicose.logitrack.dto.response;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ClientResDto implements Serializable {
    private long id;
    private String nom;
    private String email;
    private String telephone;
    private String ville;
}
