package com.nlangione.UpdateAndDelete.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlangione.UpdateAndDelete.models.Book;
import com.nlangione.UpdateAndDelete.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
	@Autowired
	private BookRepository bookRepository;
    
   
    // returns all the books
    public List<Book> allBooks() {
        return this.bookRepository.findAll();
    }
    
    // creates a book
    public Book createBook(Book b) {
        return this.bookRepository.save(b);
    }
    
    // retrieves a book
    public Book findBook(Long id) {
    	return this.bookRepository.findById(id).orElse(null);	
    }
    
	// Update Album
	public Book editBook(Book book) {
		return this.bookRepository.save(book);
	}
	
	// Delete Album
	public String deleteBook(Long id) {
		this.bookRepository.deleteById(id);
		return "Book has been deleted";
	}
}