package com.example.spring1.repositories;


import com.example.spring1.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findByCin(long cin);
    List<Etudiant> findByEcole(String ecole);
    List<Etudiant> findByNomEt(String nom);
    List<Etudiant> findByPrenomEt(String ecole);
}
