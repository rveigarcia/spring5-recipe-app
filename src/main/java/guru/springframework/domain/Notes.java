package guru.springframework.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter

@EqualsAndHashCode(exclude = {"recipe"})  // debido a la relacion bidireccional excluimos recipes
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob  // Anotación que se emplea para poder ampliar el número de caracteres
    private String recipeNotes;

}
