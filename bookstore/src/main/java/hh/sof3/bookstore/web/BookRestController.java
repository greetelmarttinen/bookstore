package hh.sof3.bookstore.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;

@RestController
public class BookRestController {
    private BookRepository bookRepository;

    // constructor injetion
    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public @ResponseBody List<Book> findAllBookdRest() {
        return (List<Book>) bookRepository.findAll();
    }

}
