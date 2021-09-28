package it.euris.academy.LibraryProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.euris.academy.LibraryProject.Model.Key.Book_PublishingHause_Key;
import it.euris.academy.LibraryProject.data.Model.Book_PublishingHause;

public interface Book_PublishingHause_Repository extends JpaRepository<Book_PublishingHause, Book_PublishingHause_Key> {
	
	@Query(value = "Select b_p.* from book_publishing_hause b_p where b_p.book_id=:bookId and b_p.publishing_hause_id=:publishingHauseId", nativeQuery = true)
	public Book_PublishingHause findByBookAndPublishingHause(@Param("bookId") Long  bookId, @Param("publishingHauseId") Long publishingHauseId);
}
