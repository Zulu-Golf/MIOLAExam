package org.cours.controller;

import org.cours.model.Etudiant;
import org.cours.model.Examen;
import org.cours.model.Professeur;
import org.cours.model.Resultat;
import org.cours.model.ResultatDTO;
import org.cours.repository.EtudiantRepository;
import org.cours.repository.ExamenRepository;
import org.cours.repository.ResultatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ResultatController {
	@Autowired
    ResultatRepository resultatRepository;
	@Autowired
	ExamenRepository examenRepository;
	@Autowired
	EtudiantRepository etudiantRepository;

    @GetMapping("/resultats")
    Iterable<Resultat> getAllResultat(){
        return resultatRepository.findAll();
    }

    @PostMapping("/resultats")
    Resultat addResultat(@RequestBody Resultat v){
        return resultatRepository.save(v);

    }
    @PostMapping(value="/resultats", headers="action=post-result-with-ids")
    Resultat addResultatWithIds(@RequestBody ResultatDTO resultatdto){
    	System.out.println(resultatdto.getNote());
    	Examen exam=new Examen();
    	Etudiant etudiant = new Etudiant();
    	exam=examenRepository.findById(resultatdto.getExamenId()).orElse(null);

    	etudiant=etudiantRepository.findById(resultatdto.getEtudiantId()).orElse(null);
    	Resultat resultat= new Resultat();
    	resultat.setEtudiant(etudiant);
    	resultat.setExamen(exam);
    	resultat.setNote(resultatdto.getNote());
        return resultatRepository.save(resultat);
    }

    @PostMapping(value="/resultats", headers="action=post-result-no-ids")
    Resultat addResultatNoIds(@RequestBody Resultat result){
    	Examen exam=new Examen();
    	Etudiant etudiant = new Etudiant();
    	long idExam=result.getExamen().getCours().getId();
    	System.out.println(idExam);
    	exam=examenRepository.findByCours(result.getExamen().getCours());
    	etudiant=etudiantRepository.findByPrenom(result.getEtudiant().getPrenom());
    	Resultat resultat= new Resultat();
    	resultat.setEtudiant(etudiant);
    	resultat.setExamen(exam);
    	resultat.setNote(result.getNote());
        return resultatRepository.save(resultat);
    }

    @GetMapping("/resultats/{id}")
    Resultat getResultatById(@PathVariable Long id){
        return resultatRepository.findById(id).orElse(null);
    }

    
    
    /*@PutMapping(value="/resultats",headers="action=put-cours")
    Resultat editResultatById(@RequestBody ResultatDTO r){
    	Resultat r1 = resultatRepository.findById(id).orElse(null);
    	
    	Examen exam=new Examen();
    	Etudiant etudiant = new Etudiant();
    	exam=examenRepository.findById(resultatdto.getExamenId()).orElse(null);
    	etudiant=etudiantRepository.findById(resultatdto.getEtudiantId()).orElse(null);
    	Resultat resultat= new Resultat();
    	resultat.setEtudiant(etudiant);
    	resultat.setExamen(exam);
    	resultat.setNote(r.getNote());
        return resultatRepository.save(resultat);
        
    }*/

    @DeleteMapping("/resultats/{id}")
    void deleteResultat(@PathVariable Long id){
    	resultatRepository.deleteById(id);
    }
}
