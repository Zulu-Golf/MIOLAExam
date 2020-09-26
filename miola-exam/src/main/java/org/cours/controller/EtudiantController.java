package org.cours.controller;

import org.cours.model.Etudiant;
import org.cours.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
public class EtudiantController {
    @Autowired
    EtudiantRepository etudiantRepository;

    @GetMapping("/etudiants")
    Iterable<Etudiant> getAllEtudiants(){
        return etudiantRepository.findAll();
    }

    @PostMapping("/etudiants")
    Etudiant addEtudiant(@RequestBody Etudiant v){
        return etudiantRepository.save(v);
    }

    @GetMapping("/etudiants/{id}")
    Etudiant geEtudiantById(@PathVariable Long id){
        return etudiantRepository.findById(id).orElse(null);
    }

    @PutMapping("/etudiants/{id}")
    Etudiant editEtudiantById(@PathVariable Long id,@RequestBody Etudiant v){
    	Etudiant v1 = etudiantRepository.findById(id).orElse(null);
        v1.setNom(v.getNom());
   return etudiantRepository.save(v1);
    }

    @DeleteMapping("/etudiants/{id}")
    void deleteEtudiant(@PathVariable Long id){
        etudiantRepository.deleteById(id);
    }
}
