package com.example.spring1.services;

import com.example.spring1.entities.Bloc;
import com.example.spring1.entities.Etudiant;
import com.example.spring1.repositories.EtudiantRepository;

import java.util.List;

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
        long idEtudiant = etudiant.getIdEtudiant();

        Etudiant existingEtudiant = etudiantRepository.findById(idEtudiant).orElse(null);

        if (existingEtudiant != null) {
            existingEtudiant.setCin(existingEtudiant.getCin());
            existingEtudiant.setEcole(existingEtudiant.getEcole());
            existingEtudiant.setDateNaissance(existingEtudiant.getDateNaissance());
            existingEtudiant.setNomEt(existingEtudiant.getNomEt());
            existingEtudiant.setPrenomEt(existingEtudiant.getPrenomEt());
            return etudiantRepository.save(existingEtudiant);
        } else {
            return null;
        }
    }

    @Override
    public void deleteEtudiantlong(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}
