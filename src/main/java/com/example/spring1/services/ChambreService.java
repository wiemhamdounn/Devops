package com.example.spring1.services;

import com.example.spring1.entities.Bloc;
import com.example.spring1.entities.Chambre;
import com.example.spring1.repositories.ChambreRepository;

import java.util.List;

public class ChambreService implements IChambreInterface{
    ChambreRepository chambreRepository;

    public ChambreService(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre getChambre(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        long idChambre = chambre.getIdChambre();

        Chambre existingChambre = chambreRepository.findById(idChambre).orElse(null);

        if (existingChambre != null) {
            existingChambre.setNumeroChambre(existingChambre.getNumeroChambre());
            existingChambre.setTypeC(existingChambre.getTypeC());
            existingChambre.setBloc(existingChambre.getBloc());
            existingChambre.setReservations(existingChambre.getReservations());

            return chambreRepository.save(existingChambre);
        } else {
            return null;
        }
    }

    @Override
    public void deleteChambre(long idChambre) {
        chambreRepository.deleteById(idChambre);
    }
}
