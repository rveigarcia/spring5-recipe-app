package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
import java.util.Optional;

@Controller
public class IndexController {
	// indicamos las posible rutas del index
    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        return "index";
    }
}
