package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Data
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
