package org.cours.repository;

import org.cours.model.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
//@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    List<Etudiant> findByNom(@Param("nom") String nom);
    Etudiant findByPrenom(@Param("prenom") String prenom);

}