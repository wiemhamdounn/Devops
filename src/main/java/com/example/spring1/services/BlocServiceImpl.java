package com.example.spring1.services;

import com.example.spring1.entities.Bloc;
import com.example.spring1.repositories.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlocServiceImpl implements IBlocService{
    BlocRepository blockRepository;
    @Autowired
    public BlocServiceImpl(BlocRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @Override
    public Bloc addBloc(Bloc block) {
        return blockRepository.save(block);
    }

    @Override
    public Bloc getBloc(long idBloc) {
        return blockRepository.findById(idBloc).orElse(null);
    }

    @Override
    public List<Bloc> getAllBlocs() {
        return blockRepository.findAll();
    }
    public void deleteBloc(long idBloc) {
         blockRepository.deleteById(idBloc);
    }
  public  Bloc updateBloc(Bloc bloc)
  {
      long idBloc = bloc.getIdBloc();

      Bloc existingBloc = blockRepository.findById(idBloc).orElse(null);

      if (existingBloc != null) {
          existingBloc.setNomBloc(existingBloc.getNomBloc());
          existingBloc.setCapaciteBloc(existingBloc.getCapaciteBloc());
          existingBloc.setFoyer(existingBloc.getFoyer());
          existingBloc.setChambres(existingBloc.getChambres());
          return blockRepository.save(existingBloc);
      } else {
          return null;
      }

    }
}
