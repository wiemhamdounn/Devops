package com.example.spring1.repositories;

import com.example.spring1.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BlocRepository extends JpaRepository<Bloc,Long> {

}
