package it.euris.academy.LibraryProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.euris.academy.LibraryProject.Service.PublishingHauseService;
import it.euris.academy.LibraryProject.data.Dto.PublishingHauseDto;

@RestController
@RequestMapping("/publishingHauses")
@ResponseStatus(HttpStatus.CREATED)
public class PublishingHauseController {
	
	@Autowired
	PublishingHauseService publishingHauseService;
	
	@GetMapping("/v1")
	public List<PublishingHauseDto> getAll(){
		return publishingHauseService.getAll();
	}

	@GetMapping("/v1/{id}")
	public PublishingHauseDto get(@PathVariable("id") Long id){
		return publishingHauseService.get(id);
	}
	@GetMapping("/v1/name/{name}")
	public List<PublishingHauseDto> getByName(@PathVariable("name") String name ){
		return publishingHauseService.getByPublishingHauseName(name);
	}
	@GetMapping("/v1/founder/{founder}")
	public List<PublishingHauseDto> getByFounder(@PathVariable("founder") String founder ){
		return publishingHauseService.getByPublishingHauseName(founder);
	}
	
	@GetMapping("/v1/total")
	public Long getTotalBookRows() {
		return publishingHauseService.getTotalPublishingHauseRows();
	}
	
	@GetMapping("/v1/total-deleted")
	public Long getTotalBookRowsDeleted() {
		return publishingHauseService.getTotalPublishingHauseDeleted();
	}
	
	@GetMapping("/v1/total-undeleted")
	public Long getTotalBookRowsNotDeleted() {
		return publishingHauseService.getTotalPublishingHauseNotDeleted();
	}

	
	@DeleteMapping("/v1/{id}")
		public Boolean delete(@PathVariable("id") Long id) {
			return  publishingHauseService.delete(id);
		}
		
	@PutMapping("/v1/")
	public PublishingHauseDto update(@RequestBody PublishingHauseDto publishingHauseDto) {
		return publishingHauseService.update(publishingHauseDto);
	}
	
	@PatchMapping("/v1")
	public PublishingHauseDto patch(@RequestBody PublishingHauseDto publishingHauseDto) {
		return publishingHauseService.update(publishingHauseDto);
	}
	
	@PostMapping("/v1")
	public PublishingHauseDto insert(@RequestBody PublishingHauseDto publishingHauseDto) {
		return publishingHauseService.add(publishingHauseDto);
	}
	
	
	
	
}
