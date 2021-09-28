package it.euris.academy.LibraryProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import it.euris.academy.LibraryProject.data.Model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	public Author findAuthorById(@Param("id") Long id);
	//public AuthorDto save(AuthorDto authorDto);
	public List<Author> findAuthorByName(@Param("name") String name);
	public List<Author> findAuthorByCountry(@Param("country") String country);
	public List<Author> findAuthorByGender(@Param("gender") String gender);
	
	@Query(value = "SELECT COUNT(*) FROM author", nativeQuery = true)
	Long getAuthorTotalRows();
	
	@Query(value = "SELECT COUNT(*) FROM author  WHERE deleted = true", nativeQuery = true)
	Long getAuthorTotalRowsDeleted();
	
	@Query(value = "SELECT COUNT(*) FROM author  WHERE deleted = false", nativeQuery = true)
	Long getAuthorTotalRowsNotDeleted();

}
