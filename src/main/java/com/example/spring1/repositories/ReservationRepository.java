package com.example.spring1.repositories;


import com.example.spring1.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
  //  List<Reservation> findByAnnneeUniversitaireBetween(Date startDate, Date endDate);
   // long countByAnnneeUniversitaireBetween(Date startDate, Date endDate);

}