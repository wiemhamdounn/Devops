package com.example.spring1.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Reservation  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idReservation")
    String idReservation ;
    Date anneeUniversite ;
    boolean estValide ;
    @ManyToOne
    Chambre chambre;
    @ManyToMany(mappedBy="reservations", cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;

}
