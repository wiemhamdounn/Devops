package com.example.spring1.controllers;

import com.example.spring1.entities.Bloc;
import com.example.spring1.entities.Etudiant;
import com.example.spring1.services.IBlocService;
import com.example.spring1.services.IEtudiantInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EtudiantController {
    IEtudiantInterface etudiantService;

    @PostMapping("/addEtudiant")
    Etudiant addEtudiant (@RequestBody Etudiant etudiant){
        return etudiantService.addEtudiant(etudiant);
    }
    @GetMapping("/etudiant/{id}")
    Etudiant retrieveEtudiant(@PathVariable long id){
        return etudiantService.getEtudiant(id);
    }
    @GetMapping("/etudiants")
    List<Etudiant> retrieveEtudiants(){
        return etudiantService.getAllEtudiants();
    }
    @DeleteMapping("/deleteEtudiant/{id}")
    void deleteEtudiant(@PathVariable long id){
        etudiantService.deleteEtudiant(id);
    }
    @PutMapping("/updateEtudiant")
    Etudiant updateEtudiant(@RequestBody Etudiant etudiant){
        return   etudiantService.updateEtudiant(etudiant);
    }

}
