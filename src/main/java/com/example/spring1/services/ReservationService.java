package com.example.spring1.services;

import com.example.spring1.entities.*;
import com.example.spring1.repositories.ChambreRepository;
import com.example.spring1.repositories.EtudiantRepository;
import com.example.spring1.repositories.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ReservationService implements IReservationRepository{
    ReservationRepository reservationRepository;
    ChambreRepository chambreRepository;
EtudiantRepository etudiantRepository;
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        Reservation r = reservationRepository.findById(reservation.getIdReservation()).orElseThrow(() -> new EntityNotFoundException("No Reservation with id " + reservation.getIdReservation() + " was found!"));
        if (r!=null){
            reservationRepository.save(reservation);}
        return r;
    }

    @Override
    public void deleteReservation(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Reservation res, Long numChambre, long cin) {

        return null;
    }

    @Override
    public long getReservationParAnneeUniversitaire(Date debutAnnee, Date finAnnee) {
        return 0;
    }


}
 