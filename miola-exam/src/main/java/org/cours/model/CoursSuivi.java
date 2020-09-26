package org.cours.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CoursSuivi {
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
	
    /*@ManyToOne
    @JoinColumn(name="etudiant_id", nullable=true)
    private Etudiant etudiant;*/
	
    @NonNull
    private Short noteFinale;
    
    @NonNull
    private Boolean rattrapage;




}
