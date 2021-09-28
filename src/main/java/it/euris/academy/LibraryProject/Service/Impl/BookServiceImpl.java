package it.euris.academy.LibraryProject.Service.Impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.euris.academy.LibraryProject.Repository.BookRepository;
import it.euris.academy.LibraryProject.Repository.Projection.PublishingHousesByBook;
import it.euris.academy.LibraryProject.Service.BookService;
import it.euris.academy.LibraryProject.data.Dto.BookDto;
import it.euris.academy.LibraryProject.data.Model.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<BookDto> getAll() {
		return bookRepository.findAll().stream().map(Book::toDto).collect(Collectors.toList());
	}

	@Override
	public BookDto get(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		return book.isPresent() ? book.get().toDto() : null;
	}

	@Override
	public BookDto insert(BookDto bookDto) {
		if(bookDto.getBookId() != null)
			throw new RuntimeException();
		return bookRepository.save(bookDto.toModel()).toDto();
	}

	@Override
	public BookDto update(BookDto bookDto) {
		if(bookDto.getBookId() == null)
			throw new RuntimeException();
			return bookRepository.save(bookDto.toModel()).toDto();
	}

	@Override
	public Boolean delete(Long id) {
		bookRepository.deleteById(id);
		return bookRepository.findById(id).isEmpty();
	}

	@Override
	public List<BookDto> getBookByTitle(String title) {
		return bookRepository.findBookByTitle(title).stream().map(Book::toDto).collect(Collectors.toList());
	}

	@Override
	public List<BookDto> getBookByGenre(String genre) {
		return bookRepository.findBookByGenre(genre).stream().map(Book::toDto).collect(Collectors.toList());
	}

	@Override
	public Long getTotalBookRows() {
		return bookRepository.getBookTotalRows();
	}

	@Override
	public Long getTotalBookRowsDeleted() {
		return bookRepository.getBookTotalRowsDeleted();
	}

	@Override
	public Long getTotalBookRowsNotDeleted() {
		return bookRepository.getBookTotalRowsNotDeleted();
	}

	@Override
	public List<BookDto> getBookByNumPages(Long numPages) {
		return  bookRepository.findBookByNumPages(numPages).stream()
				.map(Book::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<BookDto> getBookByPubblicationDate(Instant pubblicationDate) {
		 return bookRepository.findBookByPubblicationDate(pubblicationDate)
				.stream()
				.map(Book::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<BookDto> getBookByAuthor(Long Id) {
		return bookRepository.findBookByAuthorId(Id)
				.stream()
				.map(Book::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<PublishingHousesByBook> getTotalPublishingHousesByBook(Long id) {
		return bookRepository.getPublishingHousesByBook(id);
	}
}
