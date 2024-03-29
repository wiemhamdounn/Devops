package com.example.spring1.services;

import com.example.spring1.entities.Bloc;

import java.util.List;

public interface IBlocService {
   Bloc addBloc(Bloc block);
  Bloc  getBloc(long idBloc);
  List<Bloc>getAllBlocs();
   void deleteBloc(long idBloc);
   Bloc updateBloc(Bloc bloc);
    public String affecterBlocAFoyer( long idFoyer, long idBloc) ;
    public Bloc desaffecterFoyerBloc(long idBloc);
}
