package it.euris.academy.LibraryProject.data.Dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.euris.academy.LibraryProject.data.Archetype.Dto;
import it.euris.academy.LibraryProject.data.Model.Author;
import it.euris.academy.LibraryProject.utilities.EnumsUT;
import it.euris.academy.LibraryProject.utilities.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto implements Dto{

	private String authorId;
	private String authorName;
	private String authorCountry;
	private String authorBirthDate;
	private String authorGender;
	
	@JsonIgnore
	private List<BookDto> books;
	
	@Override
	public Author toModel() {
		return Author.builder()
				.id(UT.toLong(authorId))
				.name(authorName)
				.country(authorCountry)
				.birthDate(Instant.parse(authorBirthDate))
				.gender(EnumsUT.getGenderType(authorGender))
				.build();
	}
}
