package com.example.spring1.services;

import com.example.spring1.entities.Bloc;
import com.example.spring1.entities.Chambre;
import com.example.spring1.repositories.BlocRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService{
    BlocRepository blockRepository;


    @Override
    public Bloc addBloc(Bloc bloc) {
        return blockRepository.save(bloc);
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

    @Override
    public Bloc updateBloc(Bloc bloc) {
        Bloc b= blockRepository.findById(bloc.getIdBloc()).orElseThrow(() -> new EntityNotFoundException("No Bloc with id " + bloc.getIdBloc() + " was found!"));
        if (b!=null){
            blockRepository.save(bloc);}
        return b;
    }
}
