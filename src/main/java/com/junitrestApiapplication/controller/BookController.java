package com.junitrestApiapplication.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junitrestApiapplication.model.Book;
import com.junitrestApiapplication.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/allBook")
	public List<Book> getAllBooks(){
		return bookService.getAllBook();
	}
	
	@GetMapping("{id}")
	public Book getBookByID(@PathVariable Long book) {
		return bookService.getBookByID(book);
	}
	
	@PostMapping("/create")
	public Book createBook(@RequestBody @Validated Book book) {
		return bookService.createBook(book);
	}
	
	@PutMapping("/update")
	public Book updateBook(@RequestBody @Validated Book book) throws NotFoundException {
		if(book != null) {
			return bookService.updateBook(book);
		}
		else {
			 throw new NotFoundException();
		}
			
		
	}

}
