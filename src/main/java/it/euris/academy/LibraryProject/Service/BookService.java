package it.euris.academy.LibraryProject.Service;

import java.time.Instant;
import java.util.List;

import it.euris.academy.LibraryProject.Repository.Projection.PublishingHousesByBook;
import it.euris.academy.LibraryProject.data.Dto.BookDto;

public interface BookService {

	public List<BookDto> getAll();
	public BookDto get(Long id);
	public BookDto insert(BookDto bookDto);
	public BookDto update(BookDto bookDto);
	public Boolean delete(Long id);
	
	public List<BookDto> getBookByTitle(String title);
	public List<BookDto> getBookByGenre(String genre);
	public List<BookDto> getBookByNumPages(Long numPages);
	public List<BookDto> getBookByPubblicationDate(Instant pubblicationDate);
	public List<BookDto> getBookByAuthor(Long Id);
	
	public Long getTotalBookRows();
	public Long getTotalBookRowsDeleted();
	public Long getTotalBookRowsNotDeleted();
	
	public List<PublishingHousesByBook> getTotalPublishingHousesByBook(Long id);
}
