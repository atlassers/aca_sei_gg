package it.euris.academy.LibraryProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.euris.academy.LibraryProject.Service.AuthorService;
import it.euris.academy.LibraryProject.data.Dto.AuthorDto;

@RestController
@RequestMapping("/authors")
@ResponseStatus(HttpStatus.CREATED)
public class AuthorController {

	@Autowired
	AuthorService authorService;
	
	@GetMapping("/v1")
	public List<AuthorDto> getAll(){
		return authorService.getAll();
	}
	
	@GetMapping("/v1/{id}")
	public AuthorDto getById(@PathVariable("id") Long id) {
		return authorService.get(id);
	}
	
	@GetMapping("/v1/title/{title}")
	public List<AuthorDto> getByName(@PathVariable("name") String name){
			return authorService.getAuthorByName(name);
		}
	
	@GetMapping("/v1/country/{country}")
	public List<AuthorDto> getByCountry(@PathVariable("country") String country){
		return authorService.getAuthorByCountry(country);
	}
	
	@GetMapping("/v1/gender/{gender}")
	public List<AuthorDto> getByGender(@PathVariable("gender") String gender){
		return authorService.getAuthorByGender(gender);
	}
	
	@GetMapping("/v1/total")
	public Long getTotalBookRows() {
		return  authorService.getTotalAuthorRows();
	}
	
	@GetMapping("/v1/total-deleted")
	public Long getTotalBookRowsDeleted() {
		return  authorService.getTotalAuthorRowsDeleted();
	}
	
	@GetMapping("/v1/total-undeleted")
	public Long getTotalBookRowsNotDeleted() {
		return  authorService.getTotalAuthorRowsNotDeleted();
	}
	
	@DeleteMapping("/v1/{id}")
	public Boolean delete(@PathVariable("id") Long id) {
		return authorService.delete(id);
	}
	
	@PutMapping
	public AuthorDto update(@RequestBody AuthorDto authorDto) {
		return authorService.update(authorDto);
	}
	
	@PatchMapping("/v1")
	public AuthorDto patch(@RequestBody AuthorDto authorDto) {
		return authorService.update(authorDto);
	}
	
	@PostMapping("/v1")
	public AuthorDto insert(@RequestBody AuthorDto authorDto) {
		return authorService.insert(authorDto);
	}
}
