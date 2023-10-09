package com.example.spring1.services;

import com.example.spring1.entities.Foyer;

import java.util.List;

public interface IFoyerRepository {
    Foyer addFoyer(Foyer foyer);
    Foyer  getFoyer(long idFoyer);
    List<Foyer> getAllFoyers();
    public  Foyer updateFoyer(Foyer foyer);
    public void deleteFoyer( long idFoyer);
}
