package it.euris.academy.LibraryProject.data.Dto;

import java.time.Instant;

import it.euris.academy.LibraryProject.data.Archetype.Dto;
import it.euris.academy.LibraryProject.data.Model.PublishingHause;
import it.euris.academy.LibraryProject.utilities.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublishingHauseDto implements Dto{

	public String publishingHouseId;
	public String publishingHauseName;
	public String publishingHauseFoundationDate;
	public String publishingHauseFounder;
	
	@Override
	public PublishingHause toModel() {
		return PublishingHause.builder()
				.id(UT.toLong(publishingHouseId))
				.name(publishingHauseName)
				.foundationDate(Instant.parse(publishingHauseFoundationDate))
				.founder(publishingHauseFounder)
				.build();
	}
}
