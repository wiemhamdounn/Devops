package com.example.spring1.controllers;

import com.example.spring1.entities.Bloc;
import com.example.spring1.entities.Chambre;
import com.example.spring1.services.IChambreInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ChambreController {
    IChambreInterface chambreService;
    @PostMapping("/addChambre")
    Chambre addChambre (@RequestBody Chambre chambre){
        return chambreService.addChambre(chambre);
    }
    @GetMapping("/chambre/{id}")
    Chambre retrieveBloc(@PathVariable long id){
        return chambreService.getChambre(id);
    }
    @GetMapping("/chambres")
    List<Chambre> retrieveChambre(){
        return chambreService.getAllChambres();
    }
    @DeleteMapping("/deleteChambre/{id}")
    void deleteChambre(@PathVariable long id){
        chambreService.deleteChambre(id);
    }
    @PutMapping("/updateChambre")
    Chambre updateChambre(@RequestBody Chambre chambre){
        return   chambreService.updateChambre(chambre);
    }

}
