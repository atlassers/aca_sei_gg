package it.euris.academy.LibraryProject.data.Dto;

import it.euris.academy.LibraryProject.Model.Key.Book_PublishingHause_Key;
import it.euris.academy.LibraryProject.data.Archetype.Dto;
import it.euris.academy.LibraryProject.data.Model.Book;
import it.euris.academy.LibraryProject.data.Model.Book_PublishingHause;
import it.euris.academy.LibraryProject.data.Model.PublishingHause;
import it.euris.academy.LibraryProject.utilities.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book_PublishingHause_Dto implements Dto {

	private Book_PublishingHause_Key book_PublishingHause_Dto_Id;
	private String bookId;
	private String publishingHauseId;
	
	@Override
	public  Book_PublishingHause toModel() {
		return Book_PublishingHause.builder()
				.id(new Book_PublishingHause_Key(UT.toLong(bookId), UT.toLong(publishingHauseId)))
				.book(new Book(bookId))
				.publishingHause(new PublishingHause(publishingHauseId))
				.build();
	}
}
