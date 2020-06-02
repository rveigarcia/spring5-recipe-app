package guru.springframework.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"recipes"})  // debido a la relacion bidireccional excluimos recipes
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    // relacion bidireccional con receta
    @ManyToMany(mappedBy = "categories") // nombre de atributo
    private Set<Recipe> recipes;

}
