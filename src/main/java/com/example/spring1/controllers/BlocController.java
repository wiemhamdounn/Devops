package com.example.spring1.controllers;
import com.example.spring1.entities.Bloc;
import com.example.spring1.services.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
public class BlocController {
    IBlocService blocService;
   @PostMapping("/addbloc")
    Bloc addBloc ( @RequestBody  Bloc bloc){
        return blocService.addBloc(bloc);
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
}
