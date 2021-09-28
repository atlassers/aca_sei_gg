package it.euris.academy.LibraryProject.Controller;

import java.time.Instant;
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

import it.euris.academy.LibraryProject.Repository.Projection.PublishingHousesByBook;
import it.euris.academy.LibraryProject.Service.BookService;
import it.euris.academy.LibraryProject.data.Dto.BookDto;

@RestController
@RequestMapping("/books")
@ResponseStatus(HttpStatus.CREATED)
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/v1")
	public List<BookDto> getAll(){
		return bookService.getAll();
	}
	
	@GetMapping("/v1/{id}")
	public BookDto getById(@PathVariable("id") Long id) {
		return bookService.get(id);
	}
	
	@GetMapping("/v1/title/{title}")
	public List<BookDto> getByTitle(@PathVariable("title") String title){
		return bookService.getBookByTitle(title);
	}
	
	@GetMapping("/v1/genre/{genre}")
	public List<BookDto> getByGenre(@PathVariable("genre") String genre ){
		return bookService.getBookByGenre(genre);
	}
	
 	@GetMapping("/v1/numPages/{numPages}")
	public List<BookDto> getByNumPages(@PathVariable("numPages")Long numPages ){
		return bookService.getBookByNumPages(numPages);
	}
 	
 	@GetMapping("/v1/pubblicationDate/{pubblicationDate}")
 	public List<BookDto> getByPubblicationDate(@PathVariable("pubblicationDate") Instant pubbDate){
 		return bookService.getBookByPubblicationDate(pubbDate);
 	}
 	
 	@GetMapping("/v1/authorId/{authorId}")
 	public List<BookDto> getByAuthorId(@PathVariable("authorId") Long authorId){
 		return bookService.getBookByAuthor(authorId);
 	}
	
	@GetMapping("/v1/total")
	public Long getTotalBookRows() {
		return bookService.getTotalBookRows();
	}
	
	@GetMapping("/v1/total-deleted")
	public Long getTotalBookRowsDeleted() {
		return bookService.getTotalBookRowsDeleted();
	}
	
	@GetMapping("/v1/total-undeleted")
	public Long getTotalBookRowsNotDeleted() {
		return bookService.getTotalBookRowsNotDeleted();
	}
	
	@GetMapping("/v1/publishingHouse/book/{id}")
	public List<PublishingHousesByBook> getPublishingHousesByBook(@PathVariable("id") Long id){
		return bookService.getTotalPublishingHousesByBook(id);
	}

	@DeleteMapping("/v1/{id}")
	public Boolean delete(@PathVariable("id") Long id) {
		return bookService.delete(id);
	}
	
	@PutMapping("/v1")
	public BookDto update(@RequestBody BookDto cityDto) {
		return bookService.update(cityDto);
	}
	
	@PatchMapping("/v1")
	public BookDto patch(@RequestBody BookDto bookDto) {
		return bookService.update(bookDto);
	}
	
	@PostMapping("/v1")
	public BookDto insert(@RequestBody BookDto bookDto) {
		return bookService.insert(bookDto);
	}
}
