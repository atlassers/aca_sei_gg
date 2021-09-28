package it.euris.academy.LibraryProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.euris.academy.LibraryProject.Service.Book_PublishingHause_Service;
import it.euris.academy.LibraryProject.data.Dto.Book_PublishingHause_Dto;

@RestController
@RequestMapping("/book_PublishingHauses")
public class Book_PublishingHause_Controller {

	  @Autowired
	  Book_PublishingHause_Service book_PublishingHause_Service;
	  
	  @GetMapping("/v1")
	    public List<Book_PublishingHause_Dto> getAll(){
	    	return book_PublishingHause_Service.getAll();
	    }
	  
	  @GetMapping("/v1/{bookId}/{publishingHauseId}")
	  public Book_PublishingHause_Dto get(@PathVariable("bookId") Long bookId, @PathVariable("publishingHauseId") Long publishingHauseId ) {
		  return book_PublishingHause_Service.get(bookId, publishingHauseId);
	  }
	  
	  @PostMapping("/v1")
	  public Book_PublishingHause_Dto add(@RequestBody Book_PublishingHause_Dto dto){
		return  book_PublishingHause_Service.add(dto);
	  }
	  
	  @PutMapping("/v1")
	    public Book_PublishingHause_Dto  put(@RequestBody Book_PublishingHause_Dto  dto) {
	        return book_PublishingHause_Service.update(dto);
	    }
	  
	  @DeleteMapping("/v1/{bookId}/{publishingHauseId}")
	    public Boolean delete(@PathVariable("bookId") Long bookId, @PathVariable("publishingHauseId") Long publishingHauseId) {
	    return book_PublishingHause_Service.delete(bookId, publishingHauseId);
	    }
}
