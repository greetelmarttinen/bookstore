package hh.sof3.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	// testdata
	@Bean
	public CommandLineRunner createDemoRows(BookRepository bookRepository) {
		return (args) -> {
			// bookRepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929,
			// 1232323 - 21, 23.50));
			// bookRepository.save(new Book("Animal Farm", "George Orwell", 1945, 2212343 -
			// 5, 35.00));

			bookRepository.save(new Book("Clean Code", "Robert Martin", 2008, 2212343 - 5, 40.85));
			bookRepository.save(new Book("Spring in Action", "Craig Walls", 2021, 123456 - 5, 34.99));
		};
	}

}
