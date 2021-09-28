package it.euris.academy.LibraryProject.Service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.euris.academy.LibraryProject.Repository.PublishingHauseRepository;
import it.euris.academy.LibraryProject.Service.PublishingHauseService;
import it.euris.academy.LibraryProject.data.Dto.PublishingHauseDto;
import it.euris.academy.LibraryProject.data.Model.PublishingHause;

@Service
public class PublishingHauseServiceImpl implements PublishingHauseService {

	@Autowired
	private PublishingHauseRepository publishingHauseRepository;

	@Override
	public List<PublishingHauseDto> getAll() {
		return publishingHauseRepository.findAll().stream().map(PublishingHause::toDto).collect(Collectors.toList());
	}

	@Override
	public PublishingHauseDto get(Long id) {
		Optional<PublishingHause> publishingHause = publishingHauseRepository.findById(id);
		return publishingHause.isPresent() ? publishingHause.get().toDto() : null;
	}

	@Override
	public PublishingHauseDto add(PublishingHauseDto publishingHauseDto) {
		if (publishingHauseDto.getPublishingHouseId() != null)
			throw new RuntimeException();
		return publishingHauseRepository.save(publishingHauseDto.toModel()).toDto();
	}

	@Override
	public PublishingHauseDto update(PublishingHauseDto publishingHauseDto) {
		if (publishingHauseDto.getPublishingHouseId() == null)
			throw new RuntimeException();
		return publishingHauseRepository.save(publishingHauseDto.toModel()).toDto();
	}

	@Override
	public Boolean delete(Long id) {
		publishingHauseRepository.deleteById(id);
		return publishingHauseRepository.findById(id).isEmpty();
	}

	@Override
	public List<PublishingHauseDto> getByPublishingHauseName(String name) {
		return publishingHauseRepository.findPublishingHauseByName(name).stream().map(PublishingHause::toDto)
				.collect(Collectors.toList());
	}
/*
 @Override
	public List<PublishingHauseDto> getByPublishingHauseFoundationDater(String foundationDate) {
		return publishingHauseRepository.findPublishingHauseByFoundationDate(foundationDate).stream().map(PublishingHause::toDto)
				.collect(Collectors.toList());
	}
 */
	@Override
	public List<PublishingHauseDto> getByPublishingHauseFounder(String founder) {
		return publishingHauseRepository.findPublishingHauseByFounder(founder).stream().map(PublishingHause::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public Long getTotalPublishingHauseRows() {
		return publishingHauseRepository.getPublishingHauseTotalRows();
	}

	@Override
	public Long getTotalPublishingHauseDeleted() {
		return publishingHauseRepository.getPublishingHauseTotalRowsDeleted();
	}

	@Override
	public Long getTotalPublishingHauseNotDeleted() {
		return publishingHauseRepository.getPublishingHauseTotalRowsNotDeleted();
	}

}
