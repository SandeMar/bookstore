package Harjoitus.bookstore.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Harjoitus.bookstore.bookstore.domain.Book;
import Harjoitus.bookstore.bookstore.domain.BookRepository;
import Harjoitus.bookstore.bookstore.domain.Category;
import Harjoitus.bookstore.bookstore.domain.CategoryRepository;




@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			
			crepository.save(new Category("Novelli"));
			crepository.save(new Category("Romaani"));
			crepository.save(new Category("Lastenkirjat"));
			
			System.out.println("save couple of book");
			repository.save(new Book("Miina ja Manu", "Muhonen", "12345678", 1980, 12.12,crepository.findByName("Novelli").get(0)));
			repository.save(new Book("Veljekset", "Räsänen", "12345678", 1980, 12.12,crepository.findByName("Lastenkirjat").get(0)));
			
			System.out.println("fetch all books");
			for (Book book: repository.findAll()) {
				System.out.println("kirja:"+ book.toString());
			}

		};
	}
}



