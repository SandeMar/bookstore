package Harjoitus.bookstore.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Harjoitus.bookstore.bookstore.domain.Book;
import Harjoitus.bookstore.bookstore.domain.BookRepository;
import Harjoitus.bookstore.bookstore.domain.CategoryRepository;




@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	@GetMapping(value= "/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
        return "booklist";
		

}
	// Add new book
		 @RequestMapping(value = "/add")
		    public String addBook(Model model){
		    	model.addAttribute("book", new Book());
		    	model.addAttribute("categories", crepository.findAll());
		        return "addbook";
	//save book	        
		        
		    }  
		 @RequestMapping(value = "/save", method = RequestMethod.POST)
		    public String save(Book book){
		        repository.save(book);
		        return "redirect:booklist";
		    }    
		 
		 //delete book
		 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		    	repository.deleteById(bookId);
		        return "redirect:../booklist";
	}
		 
		 //edit book
		 @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
		    public String editBook(@PathVariable("id") Long Id, Model model) {
		    	model.addAttribute("book", repository.findById(Id));
		    	model.addAttribute("categories", crepository.findAll());
		    	
		    	return "editbook";
		    }   
		
	}


