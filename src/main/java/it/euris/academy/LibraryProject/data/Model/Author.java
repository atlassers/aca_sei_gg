package it.euris.academy.LibraryProject.data.Model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import it.euris.academy.LibraryProject.data.Archetype.Model;
import it.euris.academy.LibraryProject.data.Dto.AuthorDto;
import it.euris.academy.LibraryProject.data.Dto.BookDto;
import it.euris.academy.LibraryProject.enums.Gender;
import it.euris.academy.LibraryProject.utilities.EnumsUT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "author")
@SQLDelete(sql = "UPDATE author SET deleted = true WHERE id=? ")
@Where(clause = "deleted = false")
@Entity
public class Author implements Model {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "birth_Date")
	private Instant birthDate;
	
	@Column(name = "gender")
	@Enumerated(value = EnumType.STRING)
	private Gender gender;
	
	@Column(name = "deleted")
	@Builder.Default
	 private Boolean deleted = false;
	
	@OneToMany(mappedBy="author", fetch=FetchType.EAGER)
	private List<Book> books;
	
	public Author(String authorId) {
		if(authorId != null)
			this.id = Long.parseLong(authorId);
	}
	
	@Override
	public AuthorDto toDto() {
		List<BookDto> booksDto = new ArrayList<BookDto>();
		if(books != null)
			booksDto = books.stream().map(Book::toDto).collect(Collectors.toList());
		
		return AuthorDto.builder()
				.authorId(id.toString())
				.authorName(name)
				.authorCountry(country)
				.authorBirthDate(birthDate.toString())
				.authorGender(EnumsUT.toString(gender))
				.books(booksDto)
				.build();
	}
}
