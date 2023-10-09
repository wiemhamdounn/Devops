package com.example.spring1.services;

import com.example.spring1.entities.Foyer;
import com.example.spring1.entities.Reservation;
import com.example.spring1.repositories.ReservationRepository;

import java.util.List;

public class ReservationService implements IReservationRepository{
    ReservationRepository reservationRepository;

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
        String idReservation = reservation.getIdReservation();

        Reservation existingReservation= reservationRepository.findById(idReservation).orElse(null);

        if (existingReservation != null) {
            existingReservation.setAnneeUniversite(existingReservation.getAnneeUniversite());
            existingReservation.setEtudiants(existingReservation.getEtudiants());
            existingReservation.setEstValide(existingReservation.isEstValide());
            return reservationRepository.save(existingReservation);
        } else {
            return null;
        }
    }

    @Override
    public void deleteReservation(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }


}
