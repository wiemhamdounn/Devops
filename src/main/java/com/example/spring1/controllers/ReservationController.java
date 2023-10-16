package com.example.spring1.controllers;

import com.example.spring1.entities.Etudiant;
import com.example.spring1.entities.Reservation;
import com.example.spring1.services.IReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@AllArgsConstructor
public class ReservationController {
IReservationRepository reservationService;
    @PostMapping("/addReservation")
    Reservation addReservation (@RequestBody Reservation reservation){
        return reservationService.addReservation(reservation);
    }
    @GetMapping("/reservation/{id}")
    Reservation retrieveReservation(@PathVariable String id){
        return reservationService.getReservation(id);
    }
    @GetMapping("/reservations")
    List<Reservation> retrieveReservations(){
        return reservationService.getAllReservations();
    }
    @DeleteMapping("/deleteReservation/{id}")
    void deleteReservation(@PathVariable String id){
        reservationService.deleteReservation(id);
    }
    @PutMapping("/updateReservation")
    Reservation updateReservation(@RequestBody Reservation reservation){
        return   reservationService.updateReservation(reservation);
    }
}
