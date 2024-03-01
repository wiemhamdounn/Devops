package com.example.spring1.services;

import com.example.spring1.entities.Foyer;
import com.example.spring1.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationRepository {
    Reservation addReservation(Reservation reservation);
    Reservation  getReservation(String idReservation);
    List<Reservation> getAllReservations();
    public  Reservation updateReservation(Reservation reservation);
    public void deleteReservation( String idReservation);
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant (Reservation res, Long numChambre, long cin) ;
    public long getReservationParAnneeUniversitaire(Date debutAnnee, Date finAnnee ) ;

}
