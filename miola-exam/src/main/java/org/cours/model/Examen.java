package org.cours.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Examen {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
    
    @NonNull
    private Date dateExam;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cours_id")
    @NonNull
    private Cours cours;
    
    /*@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;*/
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "examen")
    @JsonIgnoreProperties("examen")
    private List<Resultat> resultats;

}
