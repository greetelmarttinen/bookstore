package hh.sof3.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof3.bookstore.domain.BookRepository;

@Controller
public class BookController {

    private BookRepository bookRepository;

    // constructor injection
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // @GetMapping("/index")
    // public String getBooks(Model model) {
    // return "booklist"; // booklist.html
    // }

    // booklist from database
    @GetMapping("/booklist")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist"; // booklist.html
    }

}
