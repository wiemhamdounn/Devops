package com.example.spring1.services;

import com.example.spring1.entities.Foyer;
import com.example.spring1.entities.Universite;
import com.example.spring1.repositories.UniversiteRepository;

import java.util.List;

public class UniversiteService implements IUniversiteRepository{
    UniversiteRepository universiteRepository;

    public UniversiteService(UniversiteRepository universiteRepository) {
        this.universiteRepository = universiteRepository;
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite getUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite updateUniversite(Universite universite) {

        long idUniversite = universite.getIdUniversite();

        Universite existingUniversite = universiteRepository.findById(idUniversite).orElse(null);

        if (existingUniversite != null) {
            existingUniversite.setNomUniversite(existingUniversite.getNomUniversite());
            existingUniversite.setAdresse(existingUniversite.getAdresse());
            return universiteRepository.save(existingUniversite);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUniversite(long idUniversite) {
    universiteRepository.deleteById(idUniversite);
    }
}
