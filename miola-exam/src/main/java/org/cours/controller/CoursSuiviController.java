package org.cours.controller;

import org.cours.model.CoursSuivi;
import org.cours.repository.CoursSuiviRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.NonNull;

@CrossOrigin
@RestController
public class CoursSuiviController {
	@Autowired
    CoursSuiviRepository coursSuiviRepository;

    @GetMapping("/courssuivi")
    Iterable<CoursSuivi> getAllResultat(){
        return coursSuiviRepository.findAll();
    }

    @PostMapping("/courssuivi")
    CoursSuivi addResultat(@RequestBody CoursSuivi v){
        return coursSuiviRepository.save(v);

    }

    @GetMapping("/courssuivi/{id}")
    CoursSuivi getResultatById(@PathVariable Long id){
        return coursSuiviRepository.findById(id).orElse(null);
    }

    @PutMapping("/courssuivi/{id}")
    CoursSuivi editVoitureById(@PathVariable Long id,@RequestBody CoursSuivi v){
    	CoursSuivi v1 = coursSuiviRepository.findById(id).orElse(null);
    	//v1.setEtudiant(v.getEtudiant());
        v1.setNoteFinale(v.getNoteFinale());
        v1.setRattrapage(v.getRattrapage());
        return coursSuiviRepository.save(v1);
    }

    @DeleteMapping("/courssuivi/{id}")
    void deleteResultat(@PathVariable Long id){
    	coursSuiviRepository.deleteById(id);
    }
}
