package org.cours.repository;
import org.cours.model.Resultat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
//@RepositoryRestResource

public interface ResultatRepository extends JpaRepository<Resultat,Long> {
  //List<Resultat> findByIdExamen(@Param("idExamen") Long idExamen);
  //Resultat findByIdEtudiant(@Param("idEtudiant") Long idEtudiant);

}