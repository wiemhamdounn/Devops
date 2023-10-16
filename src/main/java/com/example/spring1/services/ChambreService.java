package com.example.spring1.services;

import com.example.spring1.entities.Bloc;
import com.example.spring1.entities.Chambre;
import com.example.spring1.repositories.ChambreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
        Chambre ch= chambreRepository.findById(chambre.getIdChambre()).orElseThrow(() -> new EntityNotFoundException("No chambre with id " + chambre.getIdChambre() + " was found!"));
        if (ch!=null){
            chambreRepository.save(chambre);}
        return ch;
    }

    @Override
    public void deleteChambre(long idChambre) {
        chambreRepository.deleteById(idChambre);
    }
}
