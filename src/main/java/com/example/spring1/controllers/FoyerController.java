package com.example.spring1.controllers;

import com.example.spring1.entities.Etudiant;
import com.example.spring1.entities.Foyer;
import com.example.spring1.services.IFoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@AllArgsConstructor
public class FoyerController {
    IFoyerRepository foyerService;

    @PostMapping("/addFoyer")
    Foyer addFoyer(@RequestBody Foyer foyer){
        return foyerService.addFoyer(foyer);
    }
    @GetMapping("/foyer/{id}")
    Foyer retrieveFoyer(@PathVariable long id){
        return foyerService.getFoyer(id);
    }
    @GetMapping("/foyers")
    List<Foyer> retrieveFoyers(){
        return foyerService.getAllFoyers();
    }
    @DeleteMapping("/deleteFoyer/{id}")
    void deleteFoyer(@PathVariable long id){
        foyerService.deleteFoyer(id);
    }
    @PutMapping("/updateFoyer")
    Foyer updateFoyer(@RequestBody Foyer foyer){
        return   foyerService.updateFoyer(foyer);
    }
}
