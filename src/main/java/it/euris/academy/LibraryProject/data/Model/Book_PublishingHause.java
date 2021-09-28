package it.euris.academy.LibraryProject.data.Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import it.euris.academy.LibraryProject.Model.Key.Book_PublishingHause_Key;
import it.euris.academy.LibraryProject.data.Archetype.Model;
import it.euris.academy.LibraryProject.data.Dto.Book_PublishingHause_Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "book_publishingHause")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book_PublishingHause implements Model {

	@EmbeddedId
	private Book_PublishingHause_Key id;
	
	@ManyToOne
	@MapsId("bookId")
	@JoinColumn(name = "book_id")
	private Book book;
	
	@ManyToOne
	@MapsId("publishingHauseId")
	@JoinColumn(name = "publishingHause_id")
	private PublishingHause publishingHause;	
	
	@Override
	public Book_PublishingHause_Dto toDto() {
		return Book_PublishingHause_Dto.builder()
				.book_PublishingHause_Dto_Id(id)
				 .bookId(book.getId().toString())
				 .publishingHauseId( publishingHause.getId().toString())
				 .build();
	}
}
