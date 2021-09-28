package it.euris.academy.LibraryProject.Service;

import java.util.List;

import it.euris.academy.LibraryProject.data.Dto.Book_PublishingHause_Dto;

public interface Book_PublishingHause_Service {

	public List<Book_PublishingHause_Dto> getAll();
	
	public Book_PublishingHause_Dto get (Long bookId, Long publishingHauseId);
	
	public Book_PublishingHause_Dto add(Book_PublishingHause_Dto book_publishingHause_dto);
	
	public Book_PublishingHause_Dto update(Book_PublishingHause_Dto book_publishingHause_dto);
	
	public Boolean delete(Long bookId, Long publishingHauseId);
	
	
}
