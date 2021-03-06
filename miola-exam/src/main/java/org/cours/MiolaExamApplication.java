package org.cours;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cours.model.Cours;
import org.cours.model.Etudiant;
import org.cours.model.Examen;
import org.cours.model.Professeur;
import org.cours.model.Resultat;
import org.cours.model.Salle;
import org.cours.repository.ProfesseurRepository;
import org.cours.repository.ResultatRepository;
import org.cours.repository.CoursRepository;
import org.cours.repository.EtudiantRepository;
import org.cours.repository.ExamenRepository;
import org.cours.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"org.cours"})
public class MiolaExamApplication {
	@Autowired
	private EtudiantRepository EtudiantRepository;
	@Autowired
	private ProfesseurRepository professeurRepository;
	@Autowired
	private SalleRepository salleRepository;
	@Autowired
	private CoursRepository coursRepository;
	@Autowired
	private ExamenRepository examenRepository;
	@Autowired
	private ResultatRepository resultatRepository;
	public static void main(String[] args) {
		SpringApplication.run(MiolaExamApplication.class, args);

	}
	@Bean
	CommandLineRunner runner(){
		return args -> {
			Etudiant etudiant1 = new Etudiant("Ali" , "Hassan");
			Etudiant etudiant2 = new Etudiant("Najat" , "Bani");
			EtudiantRepository.save(etudiant1);
			EtudiantRepository.save(etudiant2);
			Professeur professeur1= new Professeur("Toyota",  "Corolla");
			Professeur professeur2= new Professeur("FIAT",  "PALIO");
			Professeur professeur3= new Professeur("Honda",  "CRV");
			professeurRepository.save(professeur1);
			professeurRepository.save(professeur2);
			professeurRepository.save(professeur3);
			salleRepository.save(new Salle("A24",(short) 20));
			salleRepository.save(new Salle("B8",(short) 10));
			salleRepository.save(new Salle("A36",(short) 25));
			/*Cours cours1=new Cours("Android");
			Cours cours2=new Cours("uml");
			Cours cours3=new Cours("java");*/
			Cours cours1=new Cours("Android",professeur1);
			Cours cours2=new Cours("UML",professeur1);
			Cours cours3=new Cours("JAVA",professeur2);
			coursRepository.save(cours1);
			coursRepository.save(cours2);
			coursRepository.save(cours3);
			
			Examen exam1=new Examen(new Date(),cours1);
			examenRepository.save(exam1);
			
			Resultat resultat1=new Resultat(12,etudiant1,exam1);
			Resultat resultat2=new Resultat(17,etudiant2,exam1);
			resultatRepository.save(resultat1);
			resultatRepository.save(resultat2);
			/*professeur1.addCours(cours1);
			professeur1.addCours(cours2);
			professeur1.addCours(cours3);*/
			//entityManager.persist(professeur1);
		};
	}

}
