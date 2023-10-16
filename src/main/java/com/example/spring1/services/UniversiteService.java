package com.example.spring1.services;

import com.example.spring1.entities.Bloc;
import com.example.spring1.entities.Foyer;
import com.example.spring1.entities.Universite;
import com.example.spring1.repositories.UniversiteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
        Universite u = universiteRepository.findById(universite.getIdUniversite()).orElseThrow(() -> new EntityNotFoundException("No Bloc with id " + universite.getIdUniversite() + " was found!"));
        if (u!=null){
            universiteRepository.save(universite);}
        return u;
    }

    @Override
    public void deleteUniversite(long idUniversite) {
    universiteRepository.deleteById(idUniversite);
    }
}
