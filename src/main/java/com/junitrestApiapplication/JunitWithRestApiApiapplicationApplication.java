package com.junitrestApiapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.junitrestApiapplication.model.Book;
import com.junitrestApiapplication.repository.BookRepository;

@SpringBootApplication
public class JunitWithRestApiApiapplicationApplication   {

	public static void main(String[] args) {
		SpringApplication.run(JunitWithRestApiApiapplicationApplication.class, args);
	}
//	public JunitWithRestApiApiapplicationApplication(BookRepository bookRepository) {
//		super();
//		this.bookRepository = bookRepository;
//	}
//	private BookRepository bookRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//		Book book = new Book(1L,"ada","sas",2);
//		Book book1 = new Book(2L,"ada","sas",2);
//		Book book2 = new Book(3L,"ada","sas",2);
//		
//		bookRepository.save(book);
//		bookRepository.save(book1);
//		bookRepository.save(book2);
//		
//	}

	

}
