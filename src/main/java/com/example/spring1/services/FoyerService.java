package com.example.spring1.services;

import com.example.spring1.entities.Bloc;
import com.example.spring1.entities.Etudiant;
import com.example.spring1.entities.Foyer;
import com.example.spring1.repositories.FoyerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoyerService implements IFoyerRepository{
    FoyerRepository foyerRepository;

    public FoyerService(FoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer getFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public List<Foyer> getAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        Foyer f = foyerRepository.findById(foyer.getIdFoyer()).orElseThrow(() -> new EntityNotFoundException("No Foyer with id " + foyer.getIdFoyer() + " was found!"));
        if (f!=null){
            foyerRepository.save(foyer);}
        return f;
    }

    @Override
    public void deleteFoyer(long idFoyer) {
     foyerRepository.deleteById(idFoyer);
    }
}
