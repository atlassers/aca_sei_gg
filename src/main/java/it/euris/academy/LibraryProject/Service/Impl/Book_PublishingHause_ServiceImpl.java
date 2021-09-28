package it.euris.academy.LibraryProject.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.euris.academy.LibraryProject.Repository.Book_PublishingHause_Repository;
import it.euris.academy.LibraryProject.Service.Book_PublishingHause_Service;
import it.euris.academy.LibraryProject.data.Dto.Book_PublishingHause_Dto;
import it.euris.academy.LibraryProject.data.Model.Book_PublishingHause;

@Service
public class Book_PublishingHause_ServiceImpl implements Book_PublishingHause_Service  {

	@Autowired
	public Book_PublishingHause_Repository book_PublishingHause_Repository;
	
	@Override
	public List<Book_PublishingHause_Dto> getAll() {
		return book_PublishingHause_Repository.findAll().stream().map(Book_PublishingHause::toDto).collect(Collectors.toList());
	}

	@Override
	public Book_PublishingHause_Dto get(Long bookId, Long publishingHauseId) {
		return book_PublishingHause_Repository.findByBookAndPublishingHause(bookId, publishingHauseId).toDto();
	}

	@Override
	public Book_PublishingHause_Dto add(Book_PublishingHause_Dto book_publishingHause_dto) {
		return book_PublishingHause_Repository.save(book_publishingHause_dto.toModel()).toDto();
	}

	@Override
	public Book_PublishingHause_Dto update(Book_PublishingHause_Dto book_publishingHause_dto) {
		return book_PublishingHause_Repository.save(book_publishingHause_dto.toModel()).toDto();
	}

	@Override
	public Boolean delete(Long bookId, Long publishingHauseId) {
		Book_PublishingHause entity = book_PublishingHause_Repository.findByBookAndPublishingHause(bookId, publishingHauseId);
		book_PublishingHause_Repository.delete(entity);
		return  book_PublishingHause_Repository.findById(entity.getId()).isEmpty();
	}
}
