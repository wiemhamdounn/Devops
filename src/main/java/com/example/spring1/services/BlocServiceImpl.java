package com.example.spring1.services;

import com.example.spring1.entities.Bloc;
import com.example.spring1.entities.Chambre;
import com.example.spring1.entities.Foyer;
import com.example.spring1.repositories.BlocRepository;
import com.example.spring1.repositories.FoyerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService{
    BlocRepository blockRepository;
    FoyerRepository foyerRepository;


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



    @Override
    public String affecterBlocAFoyer(long idFoyer, long idBloc) {
        String response = null;
        try {
            Optional<Foyer> optionalFoyer = foyerRepository.findById(idFoyer);
            Optional<Bloc> optionalBloc = blockRepository.findById(idBloc);

            if (optionalFoyer.isPresent() && optionalBloc.isPresent()) {
                Foyer foyer = optionalFoyer.get();
                Bloc bloc = optionalBloc.get();
                if (foyer.getCapaciteFoyerBloc() < foyer.getCapaciteFoyer()){
                bloc.setFoyer(foyer);
                blockRepository.save(bloc);
                foyer.setCapaciteFoyerBloc(foyer.getCapaciteFoyerBloc()+1);
                foyerRepository.save(foyer);
                response = "mrygl";}
            } else {
                response = "foyer or bloc not found.";

            }
        } catch (Exception e) {
            response = "Error occurred: " + e.getMessage();
        }
        return response;

    }

    @Override
    public Bloc desaffecterFoyerBloc(long idBloc) {
        Bloc bloc= blockRepository.findById(idBloc).orElse(null);
        Foyer foyer = bloc.getFoyer();
        foyer.setCapaciteFoyerBloc(foyer.getCapaciteFoyerBloc()-1);
        bloc.setFoyer(null);

        return blockRepository.save(bloc);
    }


}
