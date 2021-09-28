package it.euris.academy.LibraryProject.data.Model;

import java.time.Instant;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import it.euris.academy.LibraryProject.data.Archetype.Model;
import it.euris.academy.LibraryProject.data.Dto.BookDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "book")
@Entity
@SQLDelete(sql = "UPDATE Book SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Book implements Model {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "genre")
	private String genre;

	@Column(name = "pubblication_Date")
	private Instant pubblicationDate;

	@Column(name = "num_Pages")
	private Long numPages;

	@Column(name = "deleted")
	@Builder.Default
	private Boolean deleted = false;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private Author author;

	@OneToMany(mappedBy = "book")
	@Builder.Default
	@JsonIgnore
	private Set<Book_PublishingHause> book_PublishingHause = new HashSet<Book_PublishingHause>();

	public Book(String bookId) {
		this.id = Long.valueOf(bookId);
	}

	@Override
	public BookDto toDto() {
		return BookDto.builder().bookId(id.toString()).bookTitle(title).bookGenre(genre)
				.bookPubblicationDate(pubblicationDate.toString()).bookNumPages(numPages.toString())
				.bookAuthorId(author.getId().toString()).build();
	}
}
