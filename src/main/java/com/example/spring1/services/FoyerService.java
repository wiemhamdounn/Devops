package com.example.spring1.services;

import com.example.spring1.entities.Etudiant;
import com.example.spring1.entities.Foyer;
import com.example.spring1.repositories.FoyerRepository;

import java.util.List;

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
        long idFoyer = foyer.getIdFoyer();

        Foyer existingFoyer = foyerRepository.findById(idFoyer).orElse(null);

        if (existingFoyer != null) {
            existingFoyer.setCapaciteFoyer(existingFoyer.getCapaciteFoyer());
            existingFoyer.setNomFoyer(existingFoyer.getNomFoyer());
            existingFoyer.setUniversite(existingFoyer.getUniversite());
            existingFoyer.setCapaciteFoyer(existingFoyer.getCapaciteFoyer());
            return foyerRepository.save(existingFoyer);
        } else {
            return null;
        }
    }

    @Override
    public void deleteFoyer(long idFoyer) {
     foyerRepository.deleteById(idFoyer);
    }
}
