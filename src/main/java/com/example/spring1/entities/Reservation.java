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
    @ManyToMany(mappedBy="reservations", cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;

    public String getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }

    public Date getAnneeUniversite() {
        return anneeUniversite;
    }

    public void setAnneeUniversite(Date anneeUniversite) {
        this.anneeUniversite = anneeUniversite;
    }

    public boolean isEstValide() {
        return estValide;
    }

    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
}
