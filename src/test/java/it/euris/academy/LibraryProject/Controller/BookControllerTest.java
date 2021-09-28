package it.euris.academy.LibraryProject.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import it.euris.academy.LibraryProject.Repository.BookRepository;
import it.euris.academy.LibraryProject.Service.BookService;
import it.euris.academy.LibraryProject.data.Dto.BookDto;
import it.euris.academy.LibraryProject.data.Model.Book;
import it.euris.academy.LibraryProject.utils.TestSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class BookControllerTest {
	
	@Autowired
	private BookService bookService;
	
	@MockBean
	private BookRepository bookRepository;
	
	@Test
	 void get() {
		Long id = 1L;
		
		Book book = TestSupport.createBook(id);
		
		when(bookRepository.findById(id)).thenReturn(Optional.of(book));
		
		BookDto bookDto = bookService.get(id);
		
		assertEquals(book.getId().toString(), bookDto.getBookId());
		assertEquals(book.getTitle(), bookDto.getBookTitle());
	}
		
	@Test
	void givenDeletedBookList_WhenCalledGetBookTotalRowsDeleted_ThenTotalShouldBeSameAsMockedList() {
		
		List<Book> mockedBookList = TestSupport.createBookList();
		
		when(bookRepository.getBookTotalRowsDeleted()).thenReturn(Long.parseLong(String.valueOf(mockedBookList.size())));
		
		Long tot = bookService.getTotalBookRowsDeleted();
		
		assertEquals(tot, mockedBookList.size());
	}
		
	@Test
	void givenMockedDeletedBookList_WhenCalledGetBookTotalRowsNotDeleted_ThenTotalShouldBeSameAsMockedList() {
		
		List<Book> mockedBookList = TestSupport.createBookList();
		
		when(bookRepository.getBookTotalRowsNotDeleted()).thenReturn(Long.parseLong(String.valueOf(mockedBookList.size())));
		
		Long tot = bookService.getTotalBookRowsNotDeleted();
		
		assertEquals(tot, mockedBookList.size());
	}
		
	@Test
	void givenMockedDeletedBookList_WhenCalledGetBookTotalRows_ThenTotalShouldBeSameAsMockedList() {
		
		List<Book> mockedBookList = TestSupport.createBookList();
		
		
		Long tot = bookService.getTotalBookRowsNotDeleted();
		
		assertEquals(tot, mockedBookList.size());
	}
	
	@Test	
	void getAll() {
		List<Book> mockedBooksList = TestSupport.createBookList();
		when(bookRepository.findAll()).thenReturn(mockedBooksList);
	
		List<BookDto> booksList = bookService.getAll();
		
		assertEquals(booksList.size(), mockedBooksList.size());
		for(int i = 0; i < mockedBooksList.size(); i++)
			assertEquals(mockedBooksList.get(i).toDto(), booksList.get(i));
	}

	
}
