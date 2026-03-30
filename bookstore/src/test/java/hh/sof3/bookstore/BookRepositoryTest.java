package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@DataJpaTest
public class BookRepositoryTest {

    // injektoidaan repository testiä varten
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // testi: uuden kirjan luonti
    @Test
    public void createNewBook() {
        // tallennetaan uusi kategoria uudelle kirjalle
        Category category = new Category("Fiction");
        categoryRepository.save(category);

        // luodaan uusi kirja
        Book book = new Book("Harry Potter", "J.K. Rowling", 2015, 123456, 23.99, category);
        bookRepository.save(book);

        // luodaan kirjalle uniikki id
        assertThat(book.getBookId()).isNotNull();
    }

    // testi: kirjan haku
    @Test
    public void findBookByTitle() {
        List<Book> books = bookRepository.findByTitle("Harry Potter");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("J.K. Rowling");
    }

    // testi: kirjan poistaminen
    @Test
    public void deleteBook() {
        Category category = new Category("Fiction");
        categoryRepository.save(category);

        Book book = new Book("Harry Potter", "J.K. Rowling", 2015, 123456, 23.99, category);
        bookRepository.save(book);

        // poistetaan lisätty kirja
        bookRepository.delete(book);

        // tarkistetaan, että entity on poistunut
        assertThat(bookRepository.findById(book.getBookId())).isEmpty();
    }

}
