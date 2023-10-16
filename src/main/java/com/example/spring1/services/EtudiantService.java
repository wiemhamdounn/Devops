package com.example.spring1.services;

import com.example.spring1.entities.Bloc;
import com.example.spring1.entities.Etudiant;
import com.example.spring1.repositories.EtudiantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EtudiantService implements IEtudiantInterface{
    EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant getEtudiant(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        Etudiant e= etudiantRepository.findById(etudiant.getIdEtudiant()).orElseThrow(() -> new EntityNotFoundException("No Etudiant with id " + etudiant.getIdEtudiant() + " was found!"));
        if (e!=null){
            etudiantRepository.save(etudiant);}
        return e;
    }

    @Override
    public void deleteEtudiant(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}
