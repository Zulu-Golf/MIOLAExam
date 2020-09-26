package org.cours.controller;

import org.cours.model.Salle;
import org.cours.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class SalleController {

    @Autowired
    SalleRepository salleRepository;

    @GetMapping("/salles")
    Iterable<Salle> getAllSalles(){
        return salleRepository.findAll();
    }

    @PostMapping("/salles")
    Salle addVoiture(@RequestBody Salle v){
        return salleRepository.save(v);

    }

    @GetMapping("/salles/{id}")
    Salle getVoitureById(@PathVariable Long id){
        return salleRepository.findById(id).orElse(null);
    }

    @PutMapping("/salles/{id}")
    Salle editVoitureById(@PathVariable Long id,@RequestBody Salle v){
    	Salle v1 = salleRepository.findById(id).orElse(null);
        v1.setNom(v.getNom());
        v1.setNbPlaces(v.getNbPlaces());
        return salleRepository.save(v1);
    }

    @DeleteMapping("/salles/{id}")
    void deleteSalle(@PathVariable Long id){
        salleRepository.deleteById(id);
    }
}
