package school.learning.spring_Udemy_Starting.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import school.learning.spring_Udemy_Starting.model.Author;
import school.learning.spring_Udemy_Starting.repozitories.AuthorRepozitory;

@Controller
public class AuthorController {

    private AuthorRepozitory authorRepozitory;
    public AuthorController(AuthorRepozitory authorRepozitory) {
        this.authorRepozitory = authorRepozitory;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors",authorRepozitory.findAll());
        return "authors.Page";
    }

    @ResponseBody
    @PostMapping(path = "/addAuthor", consumes = "application/json", produces = "application/json")
    public void addAuthor(@RequestBody Author author){
        authorRepozitory.save(author);
    }

    @ResponseBody
    @GetMapping(path = "/getAllAuthors",
            produces = "application/json")
    public ResponseEntity<Iterable<Author>> getAllAuthors(){

        try {
            return new ResponseEntity<Iterable<Author>>(authorRepozitory.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Iterable<Author>>(HttpStatus.BAD_REQUEST);
        }
    }

}


//    private AuthorRepozitory authorRepozitory;
//
//    public AuthorController(AuthorRepozitory authorRepozitory){
//        this.authorRepozitory = authorRepozitory;
//    }

