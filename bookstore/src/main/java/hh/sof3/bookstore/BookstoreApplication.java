package hh.sof3.bookstore;

import hh.sof3.bookstore.domain.CategoryRepository;
import hh.sof3.bookstore.domain.User;
import hh.sof3.bookstore.domain.UserRepository;
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

	private final UserRepository userRepository;

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	BookstoreApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
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
			Category category1 = new Category("Scifi");
			categoryRepository.save(category1);
			Category category2 = new Category("Comic");
			categoryRepository.save(category2);
			Category category3 = new Category("Science");
			categoryRepository.save(category3);

			log.info("Save some sample books ");
			bookRepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, 123232321, 23.50, category1));
			bookRepository.save(new Book("Animal Farm", "George Orwell", 1945, 221234367, 35.00, category2));

			// create users: admin, user
			User user1 = new User("user", "$2a$10$NByaJ1KBpR4TOHZBxrjWXeg2zti.GfKN5Wf49EbR9uqorCumYFQii",
					"user@email.com", "USER");
			User user2 = new User("admin", "$2a$10$PrwRGTCiUc3sIceUfUuj2uV1GXWBEcJrkGPz57HOl.9hj5FKQq66q",
					"admin@email.com", "ADMIN");
			User user3 = new User("user2", "$2a$10$obhq3Fl/ir1GlJOZWBqBeO1kZELUpiWQtfeweNDM6kmEzhWCMxz3O",
					"user2@email.com", "USER");
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);

			log.info("Fetch all the categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}

			log.info("Fetch all the books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
