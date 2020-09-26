package org.cours.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Resultat {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
    
    @NonNull
    private Integer note;
    
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "etudiant_id")
    @NonNull
    @JsonIgnoreProperties("resultat")
    private Etudiant etudiant;
    
    
    @ManyToOne
    @JoinColumn(name="examen_id")
    @NonNull
    @JsonIgnoreProperties("resultats")
    private Examen examen;






}
