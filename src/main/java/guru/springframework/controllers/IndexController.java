package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	// indicamos las posible rutas del index
    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        return "index";
    }
}
