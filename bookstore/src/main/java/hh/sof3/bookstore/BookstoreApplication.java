package hh.sof3.bookstore;

import hh.sof3.bookstore.domain.CategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.Category;

@SpringBootApplication
public class BookstoreApplication {

	private final CategoryRepository categoryRepository;

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	BookstoreApplication(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		log.info("Sovellus käynnistetty");
	}

	// testdata
	@Bean
	public CommandLineRunner createDemoRows(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			log.info("Save some sample categories ");
			categoryRepository.save(new Category("Scifi"));
			categoryRepository.save(new Category("Comic"));
			categoryRepository.save(new Category("Science"));

			log.info("Save some sample books ");
			bookRepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, 123232321, 23.50,
					categoryRepository.findByName("Science").get(0)));
			bookRepository.save(new Book("Animal Farm", "George Orwell", 1945, 221234367, 35.00,
					categoryRepository.findByName("Scifi").get(0)));

		};
	}

}
