package Harjoitus.bookstore.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Harjoitus.bookstore.bookstore.domain.Book;
import Harjoitus.bookstore.bookstore.domain.BookRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			System.out.println("save couple of book");
			repository.save(new Book("Miina ja Manu", "Muhonen", "12345678", 1980, 12.12));
			repository.save(new Book("Veljekset", "Räsänen", "12345678", 1980, 12.12));	
			
			System.out.println("fetch all books");
			for (Book book: repository.findAll()) {
				System.out.println("kirja:"+ book.toString());
			}

		};
	}
}



