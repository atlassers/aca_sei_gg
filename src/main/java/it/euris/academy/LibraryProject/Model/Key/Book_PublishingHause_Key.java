package it.euris.academy.LibraryProject.Model.Key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Book_PublishingHause_Key implements Serializable {

	private static final long serialVersionUID = 1L;
	  
	
	@Column(name = "book_id")
	Long bookId;
	
	@Column(name = "publishingHause_id")
	Long publishingHauseId;
}
