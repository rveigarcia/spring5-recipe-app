package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
	
	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;
	
	

	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	// indicamos las posible rutas del index
    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        
    	Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
    	Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
    	
    	System.out.println("Cat Id is: " + categoryOptional.get().getId());
    	System.out.println("VOM Id is: " + unitOfMeasureOptional.get().getId());
    	
    	return "index";
    }
}
