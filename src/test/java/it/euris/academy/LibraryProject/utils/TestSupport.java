package it.euris.academy.LibraryProject.utils;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;

import it.euris.academy.LibraryProject.data.Model.Author;
import it.euris.academy.LibraryProject.data.Model.Book;
import it.euris.academy.LibraryProject.data.Model.Book_PublishingHause;

public class TestSupport {
	
	public static Book createBook(Long id) {
		var author = new Author();
		var pubHouse = new HashSet<Book_PublishingHause>();
		
		return Book.builder()
		.author(author)
		.book_PublishingHause(pubHouse)
		.deleted(Boolean.FALSE)
		.genre("Fantasy")
		.numPages(Long.MAX_VALUE) 
		.title("Il Libro Infinito")
		.pubblicationDate(Instant.MAX)
		.id(id).build();
		
	}
	public static List<Book> createBookList(){
		return List.of(createBook(1L), createBook(2L));
	}
}
