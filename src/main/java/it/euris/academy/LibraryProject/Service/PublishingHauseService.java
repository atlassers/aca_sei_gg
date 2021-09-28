package it.euris.academy.LibraryProject.Service;

import java.util.List;

import it.euris.academy.LibraryProject.data.Dto.PublishingHauseDto;

public interface PublishingHauseService {
	
	public List<PublishingHauseDto> getAll();
	
	public PublishingHauseDto get(Long id);
	
	public  PublishingHauseDto add( PublishingHauseDto publishingHauseDto);
	
	public  PublishingHauseDto update( PublishingHauseDto publishingHauseDto);
	
	public Boolean delete(Long id);
	
	public List<PublishingHauseDto> getByPublishingHauseName(String name);
	
	//public List<PublishingHauseDto> getByPublishingHauseFoundationDater(String foundationDate);
	
	public List<PublishingHauseDto> getByPublishingHauseFounder(String founder);
	
	public Long getTotalPublishingHauseRows();
	public Long getTotalPublishingHauseDeleted();
	public Long getTotalPublishingHauseNotDeleted();

}
