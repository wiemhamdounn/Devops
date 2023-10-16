package com.example.spring1.services;

import com.example.spring1.entities.Chambre;
import com.example.spring1.entities.Etudiant;

import java.util.List;

public interface IEtudiantInterface {
    Etudiant addEtudiant(Etudiant etudiant);
    Etudiant  getEtudiant(long idEtudiant);
    List<Etudiant> getAllEtudiants();
    public  Etudiant updateEtudiant(Etudiant etudiant);
    public void deleteEtudiant( long idEtudiant);
}
