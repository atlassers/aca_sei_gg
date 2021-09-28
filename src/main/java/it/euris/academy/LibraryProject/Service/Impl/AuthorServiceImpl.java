package it.euris.academy.LibraryProject.Service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.euris.academy.LibraryProject.Repository.AuthorRepository;
import it.euris.academy.LibraryProject.Service.AuthorService;
import it.euris.academy.LibraryProject.data.Dto.AuthorDto;
import it.euris.academy.LibraryProject.data.Model.Author;

@Service
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public List<AuthorDto> getAll(){
		return authorRepository.findAll().stream().map(Author::toDto).collect(Collectors.toList());
	}

	@Override
	public AuthorDto get(Long id) {
		Optional<Author> author = authorRepository.findById(id);
		return author.isPresent() ? author.get().toDto() : null;
	}

	@Override
	public AuthorDto insert(AuthorDto authorDto) {
		if(authorDto.getAuthorId() != null) 
			throw new RuntimeException();
			return authorRepository.save(authorDto.toModel()).toDto();
	}

	@Override
	public AuthorDto update(AuthorDto authorDto) {
		if(authorDto.getAuthorId() == null)
			throw new RuntimeException();
		return authorRepository.save(authorDto.toModel()).toDto();
	}

	@Override
	public Boolean delete(Long id) {
		authorRepository.deleteById(id);
		return authorRepository.findById(id).isEmpty();
	}

	@Override
	public List<AuthorDto> getAuthorByName(String name) {
		return authorRepository.findAuthorByName(name).
				stream().
				map(Author::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<AuthorDto> getAuthorByCountry(String country) {
		return authorRepository.findAuthorByCountry(country)
				.stream()
				.map(Author::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<AuthorDto> getAuthorByGender(String gender) {
		return authorRepository.findAuthorByGender(gender).
				stream().
				map(Author::toDto).
				collect(Collectors.toList());
	}

	@Override
	public Long getTotalAuthorRows() {
		return authorRepository.getAuthorTotalRows();
	}

	@Override
	public Long getTotalAuthorRowsDeleted() {
		return authorRepository.getAuthorTotalRowsDeleted();
	}

	@Override
	public Long getTotalAuthorRowsNotDeleted() {
		return authorRepository.getAuthorTotalRowsNotDeleted();
	}
}
