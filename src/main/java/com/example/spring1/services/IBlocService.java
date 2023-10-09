package com.example.spring1.services;

import com.example.spring1.entities.Bloc;

import java.util.List;

public interface IBlocService {
   Bloc addBloc(Bloc block);
  Bloc  getBloc(long idBloc);
  List<Bloc>getAllBlocs();
}
