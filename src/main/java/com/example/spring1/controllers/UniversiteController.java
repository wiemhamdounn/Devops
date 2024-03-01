package com.example.spring1.controllers;

import com.example.spring1.entities.Etudiant;
import com.example.spring1.entities.Universite;
import com.example.spring1.services.IUniversiteRepository;
import com.example.spring1.services.UniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@AllArgsConstructor
public class UniversiteController {
IUniversiteRepository universiteService;
    @PostMapping("/addUniversite")
    Universite addUniversite (@RequestBody Universite universite){
        return universiteService.addUniversite(universite);
    }
    @GetMapping("/universite/{id}")
    Universite retrieveUniversite(@PathVariable long id){
        return universiteService.getUniversite(id);
    }
    @GetMapping("/universites")
    List<Universite> retrieveUniversites(){
        return universiteService.getAllUniversites();
    }
    @DeleteMapping("/deleteUniversite/{id}")
    void deleteUniversite(@PathVariable long id){
        universiteService.deleteUniversite(id);
    }
    @PutMapping("/updateUniversite")
    Universite updateUniversite(@RequestBody Universite universite){
        return   universiteService.updateUniversite(universite);
    }

    @PutMapping("/universite/{idFoyer}/{idUniversite}")
    public  Universite affecterFoyerUniversite(@PathVariable long idFoyer, @PathVariable long idUniversite){
        return universiteService.affecterFoyerUniversite(idFoyer,idUniversite);
    }
}
