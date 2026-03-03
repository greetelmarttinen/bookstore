package hh.sof3.bookstore.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;

@RestController
public class BookRestController {
    private BookRepository bookRepository;

    // constructor injection
    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // RESTful service to get ALL BOOKS
    // Java Book class --> JSON
    @GetMapping("/books")
    public @ResponseBody List<Book> findAllBookdRest() {
        return (List<Book>) bookRepository.findAll();
    }

    // RESTful service to find ONE BOOK BY ID
    @GetMapping("/books/{id}")
    public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId).get();
    }

}
