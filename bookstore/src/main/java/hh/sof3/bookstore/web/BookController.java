package hh.sof3.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof3.bookstore.domain.Book;
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
        // booklist data comes from book repository
        // findAll fetches all books from the database
        model.addAttribute("books", bookRepository.findAll());
        return "booklist"; // booklist.html
    }

    // add new book (form)
    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook"; // addbook.html
    }

    // saving book
    @PostMapping("/savebook")
    public String save(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:booklist"; // booklist.html
    }

    // delete book
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        bookRepository.deleteById(bookId);
        return "redirect:../booklist"; // booklist.html
    }

}
