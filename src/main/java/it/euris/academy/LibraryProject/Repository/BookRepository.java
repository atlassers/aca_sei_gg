package it.euris.academy.LibraryProject.Repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.euris.academy.LibraryProject.Repository.Projection.PublishingHousesByBook;
import it.euris.academy.LibraryProject.data.Model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	public Book findBookById(@Param("id") Long id);
	public List<Book> findBookByTitle(@Param("title") String title);
	public List<Book> findBookByGenre(@Param("genre") String genre);
	public List<Book> findBookByNumPages(@Param("numPages") Long numPages);
	public List<Book> findBookByPubblicationDate(@Param("pubblicationDate") Instant pubblicationDate);
	public List<Book> findBookByAuthorId(@Param("id") long id);
	
	@Query(value = "SELECT COUNT(*) FROM Book", nativeQuery = true)
	Long getBookTotalRows();
	
	@Query(value = "SELECT COUNT(*) FROM Book WHERE deleted = true", nativeQuery = true)
	Long getBookTotalRowsDeleted();
	
	@Query(value = "SELECT COUNT(*) FROM book WHERE deleted = false", nativeQuery = true)
	Long getBookTotalRowsNotDeleted();
	
	/*
	 * SELECT COUNT(*) AS totalPublishingHousesByBook FROM academy_libraryproject.publishing_hause AS p"
			+ "JOIN academy_libraryproject.book_publishing_hause bp ON p.id = bp.publishing_hause_id"
			+ "JOIN academy_libraryproject.book b ON bp.book_id = b.id"
			+ "WHERE(bp.book_id =:id)
	 */
	@Query(value = "SELECT COUNT(IF(book_id =:id, 1, NULL)) AS totalPublishingHousesByBook FROM academy_libraryproject.book_publishing_hause ", nativeQuery = true)
	public List<PublishingHousesByBook> getPublishingHousesByBook(@Param("id") Long id );
	
}
