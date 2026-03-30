package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof3.bookstore.web.BookController;

// käynnistää Spring-sovelluksen
@SpringBootTest
public class BookstoreApplicationTests {

	// riippuvuuden injektointi
	@Autowired
	private BookController bookController;
	// tällä Spring yrittää luoda BookController-olion ja injektoi sen muuttujaan
	// bookcontroller

	// "oikea" testi käynnistetään
	@Test
	public void contextLoads() {
		// AsserJ tarkistaa, onko bookcontroller olemassa, eli ei ole null
		assertThat(bookController).isNotNull();
	}

}
