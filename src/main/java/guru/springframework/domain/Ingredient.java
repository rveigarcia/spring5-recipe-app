package guru.springframework.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})  // debido a la relacion bidireccional excluimos recipes

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

 // se define relación unudiresccional oneToon con UnitOfMesure
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;


    //private UnitOfMeasure uom;
    // de establece unarelacion bidireccional con Recipe
    @ManyToOne
    private Recipe recipe;
    
    public Ingredient() {
    }
    // constructor necesario a crearse el método addIngredient en Recipe
    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
        this.recipe = recipe;
    }
}
