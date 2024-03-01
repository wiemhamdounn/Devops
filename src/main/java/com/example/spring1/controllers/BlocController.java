package com.example.spring1.controllers;
import com.example.spring1.entities.Bloc;
import com.example.spring1.services.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class BlocController {
    IBlocService blocService;
    @PostMapping("/addBloc")
    public ResponseEntity<Bloc> addBloc(@RequestBody Bloc bloc) {
        Bloc addedBloc = blocService.addBloc(bloc);
        return new ResponseEntity<>(addedBloc, HttpStatus.OK);
    }
    @GetMapping("/bloc/{id}")
    Bloc retrieveBloc(@PathVariable long id){
        return blocService.getBloc(id);
    }
    @GetMapping("/blocs")
    List<Bloc> retrieveBlocs(){
        return blocService.getAllBlocs();
    }
    @DeleteMapping("/deleteBloc/{id}")
    void deleteBloc(@PathVariable long id){
        blocService.deleteBloc(id);
    }
    @PutMapping("/updateBloc/{id}")
    Bloc updateBloc(@RequestBody Bloc bloc){
      return   blocService.updateBloc(bloc);
    }

    @PutMapping("/affecterFoyerBloc/{idFoyer}/{idBloc}")
    public ResponseEntity<Map<String, String>> affecterFoyerBloc(@PathVariable long idFoyer, @PathVariable long idBloc) {
        try {
            String response = blocService.affecterBlocAFoyer(idFoyer, idBloc);
            Map<String, String> responseBody = new HashMap<>();
            responseBody.put("message", response);

            if ("mrygl".equals(response)) {
                return ResponseEntity.ok(responseBody);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("message", "Une exception s'est produite du côté serveur."));
        }
    }

    @PutMapping("/desaffecterFoyerBloc/{idBloc}")
    public Bloc desaffecterFoyerBloc(@PathVariable long idBloc)
    {
        return blocService.desaffecterFoyerBloc(idBloc);
    }



}
