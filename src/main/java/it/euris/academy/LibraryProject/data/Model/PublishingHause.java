package it.euris.academy.LibraryProject.data.Model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import it.euris.academy.LibraryProject.data.Archetype.Model;
import it.euris.academy.LibraryProject.data.Dto.PublishingHauseDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name= "publishingHause")
@Entity
@SQLDelete(sql = "UPDATE publishingHause SET deleted = true WHERE id=? ")
@Where(clause = "deleted = false")
public class PublishingHause implements Model {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "foundation_Date")
	private Instant foundationDate;
	
	@Column(name = "founder")
	private String founder;
	
	@Column(name = "deleted")
	@Builder.Default
	 private Boolean deleted = false;
	
	@OneToMany(mappedBy = "publishingHause")
	@Builder.Default
	@JsonIgnore
	private Set<Book_PublishingHause> book_PublishingHause = new HashSet<Book_PublishingHause>();
	
	public PublishingHause(String publishingHauseId) {
		this.id = Long.valueOf(publishingHauseId);
	}

	@Override
	public PublishingHauseDto toDto() {
		return PublishingHauseDto.builder()
				.publishingHouseId(id.toString())
				.publishingHauseName(name)
				.publishingHauseFoundationDate(foundationDate.toString())
				.publishingHauseFounder(founder)
				.build();
	}

	
	
	
	
	
	
	
	
	
	

}
