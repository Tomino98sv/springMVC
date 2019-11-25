package school.learning.spring_Udemy_Starting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import school.learning.spring_Udemy_Starting.repozitories.AuthorRepozitory;

@Controller
public class AuthorController {

    private AuthorRepozitory authorRepozitory;

    public AuthorController(AuthorRepozitory authorRepozitory){
        this.authorRepozitory = authorRepozitory;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors",authorRepozitory.findAll());
        return "authors.Page";
    }

}
