package it.euris.academy.LibraryProject.Service;

import java.util.List;

import it.euris.academy.LibraryProject.data.Dto.AuthorDto;

public interface AuthorService {
	
	public List<AuthorDto> getAll();
	public AuthorDto get(Long id);
	public AuthorDto insert(AuthorDto authorDto);
	public AuthorDto update(AuthorDto authorDto);
	public Boolean delete(Long id);
	
	public List<AuthorDto> getAuthorByName(String name);
	public List<AuthorDto> getAuthorByCountry(String country);
	public List<AuthorDto> getAuthorByGender(String Gender);

	public Long getTotalAuthorRows();
	public Long getTotalAuthorRowsDeleted();
	public Long getTotalAuthorRowsNotDeleted();
}
