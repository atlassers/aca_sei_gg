package it.euris.academy.LibraryProject.data.Dto;

import java.time.Instant;

import it.euris.academy.LibraryProject.data.Archetype.Dto;
import it.euris.academy.LibraryProject.data.Model.Author;
import it.euris.academy.LibraryProject.data.Model.Book;
import it.euris.academy.LibraryProject.utilities.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto implements Dto{
	
	public String bookId;
	public String bookTitle;
	public String bookGenre;
	public String bookPubblicationDate;
	public String bookNumPages;
    private String bookAuthorId;
	
	@Override
	public Book toModel() {
		return Book.builder()
				.id(UT.toLong(bookId))
				.title(bookTitle)
				.genre(bookGenre)
				.pubblicationDate(Instant.parse(bookPubblicationDate))
				.numPages(Long.parseLong(bookNumPages))
				.author(new Author(bookAuthorId))
				.build();
	}
	
}
