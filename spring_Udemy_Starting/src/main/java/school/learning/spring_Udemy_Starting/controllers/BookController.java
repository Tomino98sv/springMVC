package school.learning.spring_Udemy_Starting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import school.learning.spring_Udemy_Starting.repozitories.BookRepozitory;

@Controller
public class BookController {

    private BookRepozitory bookRepozitory;

    public BookController(BookRepozitory bookRepozitory){
        this.bookRepozitory = bookRepozitory;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books",bookRepozitory.findAll());
        return "books.Page";
    }
}
