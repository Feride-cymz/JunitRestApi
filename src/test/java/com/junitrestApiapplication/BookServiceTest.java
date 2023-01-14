package com.junitrestApiapplication;

import static org.hamcrest.CoreMatchers.allOf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.error.ShouldHaveSameSizeAs;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junitrestApiapplication.model.Book;
import com.junitrestApiapplication.repository.BookRepository;
import com.junitrestApiapplication.service.BookService;

import ch.qos.logback.core.net.ObjectWriter;
import ch.qos.logback.core.status.Status;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

	
	
	private MockMvc mockMvc;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	//ObjectWriter  objectWriter = objectMapper.writer();
	
	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookService bookService; 
	
	Book book1 = new Book(1L,"Red Weld", "SS.K",12);
	Book book2 = new Book(2L,"Blue Weld", "SS.K",13);
	Book book3 = new Book(3L,"Yellow Weld", "SS.K",14);
	
	@Before()
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(bookRepository).build();
	}
	
	@Test
	public void getAllBook_success() throws Exception{
		List<Book> books = new ArrayList<>(Arrays.asList(book1,book2,book3));
		Mockito.when(bookRepository.findAll()).thenReturn(books);
		
		
	}
	
}
