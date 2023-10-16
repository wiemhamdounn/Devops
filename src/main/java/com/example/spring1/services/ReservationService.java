package com.example.spring1.services;

import com.example.spring1.entities.Bloc;
import com.example.spring1.entities.Foyer;
import com.example.spring1.entities.Reservation;
import com.example.spring1.repositories.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
        Reservation r = reservationRepository.findById(reservation.getIdReservation()).orElseThrow(() -> new EntityNotFoundException("No Reservation with id " + reservation.getIdReservation() + " was found!"));
        if (r!=null){
            reservationRepository.save(reservation);}
        return r;
    }

    @Override
    public void deleteReservation(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }


}
