package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookJPARepository bookRepository;

    public BookController(BookJPARepository jpaRepository) {
        this.bookRepository = jpaRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model)
    {
        model.addAttribute("books",bookRepository.findAll());
        return "books/list";
    }
}
