package it.euris.academy.LibraryProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.euris.academy.LibraryProject.data.Model.PublishingHause;

public interface PublishingHauseRepository extends JpaRepository<PublishingHause, Long>{

	public PublishingHause findPublishingHauseById(@Param("id") Long id);
	
	public List<PublishingHause> findPublishingHauseByName(@Param("name") String name);
	
	//public List<PublishingHause> findPublishingHauseByFoundationDate(@Param("foundationDate") String foundationDate);
	
	public List<PublishingHause> findPublishingHauseByFounder(@Param("founder") String founder); 
	
	@Query(value = "SELECT COUNT(*) FROM publishing_hause", nativeQuery = true)
	Long getPublishingHauseTotalRows();
	
	@Query(value = "SELECT COUNT(*) FROM publishing_hause WHERE deleted = true", nativeQuery = true)
	Long getPublishingHauseTotalRowsDeleted();
	
	@Query(value = "SELECT COUNT(*) FROM publishing_hause WHERE deleted = false", nativeQuery = true)
	Long getPublishingHauseTotalRowsNotDeleted();
}
