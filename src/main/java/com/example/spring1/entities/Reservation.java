package com.example.spring1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idReservation")
    String idReservation ;
    Date anneeUniversite ;
    boolean estValide ;
    @ManyToMany(mappedBy="reservations", cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;

}
