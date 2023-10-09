package com.example.spring1.services;

import com.example.spring1.entities.Foyer;
import com.example.spring1.entities.Universite;

import java.util.List;

public interface IUniversiteRepository {
    Universite addUniversite(Universite universite);
    Universite  getUniversite(long idUniversite);
    List<Universite> getAllUniversites();
    public  Universite updateUniversite(Universite universite);
    public void deleteUniversite( long idUniversite);
}
