package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    // de establece unarelacion bidireccional con Ingredient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();


    @Lob // Anotación que se emplea para poder ampliar el número de caracteres
    private Byte[] image;
    
    @Enumerated(value= EnumType.STRING) // El enumerado persistirá en BBDD como un String
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    // relacion bidireccional con categoría
    @ManyToMany
    @JoinTable(name = "recipe_category",	// nombre de tabla en BBDD
        joinColumns = @JoinColumn(name = "recipe_id"), // nombre de atributo en BBDD
            inverseJoinColumns = @JoinColumn(name = "category_id"))  //// nombre de atributo BBDD

    private Set<Category> categories = new HashSet<>();


    // modificamos el setter para que incluya un Note por la relación OneToOne

    public void setNotes(Notes notes) {
        if (notes != null) {
            this.notes = notes;
            notes.setRecipe(this);
        }
    }
    // se ha creado este método para añadir ingrdientes a la receta
    public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

}
