package com.junitrestApiapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.junitrestApiapplication.model.Book;
import com.junitrestApiapplication.repository.BookRepository;

@Service
public class BookService {
	
	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> getAllBook(){
		return bookRepository.findAll();
	}
	
	public Book getBookByID(Long id) {
		return bookRepository.findById(id).get();
	}
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book updateBook(Book book) throws NotFoundException {
		if(book == null || book.getId() == null) {
			throw new NotFoundException();
		}
		Optional<Book> optionalBook = bookRepository.findById(book.getId());
		if(!optionalBook.isPresent()) {
			throw new NotFoundException();
		}
		Book existBook = optionalBook.get();
		existBook.setName(book.getName());
		existBook.setSummary(book.getSummary());
		existBook.setRating(book.getRating());
		bookRepository.save(existBook);
		return existBook;
	}

}
