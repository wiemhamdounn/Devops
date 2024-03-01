package com.example.spring1.services;

import com.example.spring1.entities.Bloc;
import com.example.spring1.entities.Chambre;
import com.example.spring1.entities.TypeChambre;

import java.util.List;

public interface IChambreInterface {
    Chambre addChambre(Chambre chambre);
    Chambre  getChambre(long idChambre);
    List<Chambre> getAllChambres();
    public  Chambre updateChambre(Chambre chambre);
    public void deleteChambre(long idChambre);
    public List<Chambre> getChambresParNomBloc( String nomBloc) ;
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) ;
}
