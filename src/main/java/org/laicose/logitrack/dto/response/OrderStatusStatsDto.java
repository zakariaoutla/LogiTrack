package org.laicose.logitrack.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusStatsDto implements Serializable {

    private long enAttente;
    private long expediees;
    private long livrees;

}