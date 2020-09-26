package org.cours.controller;

import org.cours.model.Examen;
import org.cours.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ExamenController {
	@Autowired
    ExamenRepository examenRepository;

    @GetMapping("/examens")
    Iterable<Examen> getAllExamen(){
        return examenRepository.findAll();
    }

    @PostMapping("/examens")
    Examen addExamen(@RequestBody Examen v){
        return examenRepository.save(v);

    }

    @GetMapping("/examens/{id}")
    Examen getExamenById(@PathVariable Long id){
        return examenRepository.findById(id).orElse(null);
    }
    /*@GetMapping("/examens/{nom}")
    Examen getResultatById(@PathVariable String nom){
        return examenRepository.findByNomCours(nom);
    }*/

    @PutMapping("/examens/{id}")
    Examen editExamenById(@PathVariable Long id,@RequestBody Examen v){
    	Examen v1 = examenRepository.findById(id).orElse(null);
        v1.setCours(v.getCours());
        return examenRepository.save(v1);
    }

    @DeleteMapping("/examens/{id}")
    void deleteExamen(@PathVariable Long id){
    	examenRepository.deleteById(id);
    }
}
