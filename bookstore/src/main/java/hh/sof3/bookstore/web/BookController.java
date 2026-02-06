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
        // täällä tehdään tyhjä kirja
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

    // edit book
    @GetMapping("/edit/{id}")
    // book haetaan repositoriosta ja laitetaan modeliin
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        // Spring HAKEE url:ista OLEMASSA OLEVAN KIRJAN ID:n perusteella ja tallentaa
        // sen muuttujaan bookId
        // --> tällä tiedetään mitä muuttujaa halutaan muokata
        // lisätään se modeliin näkymää (view) varten

        Book book = bookRepository.findById(bookId).orElse(null);
        // bookRepository.findById --> hakee kirjan tietokannasta id:n perusteella
        // palautuu "laatikko", jossa kirja joko on tai ei
        // .orElse(null) --> ottaa book ulos laatikosta
        // Book book --> tallennetaan book -olioksi, jota thymeleaf voi käyttää

        model.addAttribute("book", book);
        // lisätään NYKYINEN book -olio modeliin
        // --> lomakenäkymään, jossa kentät on TÄYTETTY VALMIIKSI (thymeleaf ominaisuus)
        // --> käyttäjä voi MUOKATA niitä

        return "addbook";
        // palautetaan addbook.html -näkymä, jossa kirjan tietoja voi muokata
    }

}
