const path = '/books/v1';
class BookService {
	constructor() { }

	static getTotals() {
		BaseService.getAll(path + "/total").then(function(bookTotal) {
			$("#totalBook").text(bookTotal)
		});

		BaseService.getAll(path + "/total-undeleted").then(function(bookValidTotal) {
			$("#totalBookValid").text(bookValidTotal);
		});

		BaseService.getAll(path + "/total-deleted").then(function(bookNotValidTotal) {
			$("#totalBookNotValid").text(bookNotValidTotal);
		});
	}

	static getAll() {
		BaseService.getAll(path)
			.then(function(bookDtoList) {
				var content = '<table class="aca-fill>"';
				content += '<tr>'
					+ '<th scope= "col">BookId</th>'
					+ '<th scope="col">AuthorId</th>'
					+ '<th scope="col">Title</th>'
					+ '<th scope="col">Genre</th>'
					+ '<th scope="col">PubblicationDate</th>'
					+ '<th scope="col">NumPages</th>'
					+ '<th scope="col">Detail</th>'
					+ '<th scope="col">Action</th>'
					+ '</tr>';
				jQuery.each(bookDtoList, function(i, val) {
					content += '<tr>'
						+ '<td>' + val.bookId + '</td>'
						+ '<td>' + val.bookAuthorId + '</td>'
						+ '<td>' + val.bookTitle + '</td>'
						+ '<td>' + val.bookGenre + '</td>'
						+'<td>' + val.bookPubblicationDate + '</td>'
						+ '<td>' + val.bookNumPages + '</td>'
						+ '<td><button id="btnDetail-' + val.bookId + '" class="btn btn-warning" onclick="BookService.detail(' + val.bookId + ')">detail</button></td>'
						+ '<td><button id="btnDelete-' + val.bookId + '" class="btn btn-danger" onclick="BookService.delete(' + val.bookId + ')">delete</button></td>'
						+ '</tr>';
				});
				content += '</table>';

				$('#saveForm').trigger('reset');
				$('#saveForm').hide();
				$('.table').empty();
				$('.table').append(content);
				$('.table').show();
			});
	}
	static post(formData) {
		BaseService.post(path, formData)
			.then(function(bookDto) {
				window.alert("The book has been registered")
				$('#saveForm').trigger('reset');
				$('#saveForm').hide();

				BookService.getAll();
				BookService.getTotals();
			});
	}


	static put(formData) {
		BaseService.put(path, formData)
			.then(function(bookDto) {
				window.alert("The book has been updated")
				$('#saveForm').trigger('reset');
				$('#saveForm').hide();

				BookService.getAll();
				BookService.getTotals();
			});
	}

	static delete(id) {
		BaseService.delete(path, id)
			.then(function(result) {
				window.alert('Book ' + id + ' successfully deleted!')

				BookService.getAll();
				BookService.getTotals();
			});
	}
	
	static statistics(id){
		$('#statistic').empty();
		$('#statisticalForm').show();
		
	}
	

	static detail(id) {
		BaseService.get('/books/v1', id)
			.then(function(bookDto) {
				// il bookId  corrisponda all' input id del div a riga 106 dell'html così gli altri
				// inoltre occhio perchè avevo scritto id invece di bookId in bookDto.bookId, quindi non lo pescava
				document.getElementById('bookId').value = bookDto.bookId;
				document.getElementById('bookAuthorId').value = bookDto.bookAuthorId;
				document.getElementById('bookTitle').value = bookDto.bookTitle;
				document.getElementById('bookGenre').value = bookDto.bookGenre;
				document.getElementById("bookPubblicationDate").value = bookDto.bookPubblicationDate;
				document.getElementById("bookNumPages").value = bookDto.bookNumPages;
				

				$('.table').empty();
				$('.table').hide();
				$('#saveForm').show();
			});
			
			BookService.statistics(id);
		}
		
		// definisco statistics
		
		static statistics(id){
			$('#statistics').empty();
			$('#statisticalForm').show();
			BookService.getTotalPublishingHousesByBook(id).then(function(totalPublishingHousesByBook){
				var content = '<table class= "aca fill">';
				content += '<tr>'
					+ '<th scope="col">PublishingHousesByBook</th>'
					+ '</tr>';
					jQuery.each(totalPublishingHousesByBook, function(i, result) {
					content += '<tr>'
					+ '<td>' + result.totalPublishingHousesByBook + '</td>'
					+ '</tr>';
				});
				content += '</table>'
				$('#statistics').append(content);
				$('#statistics').show();
			});
		}
		
		// fuori al detail questo in pratica richiama le projection, o meglio i getmapping delle projection nel controller
		 
	static getTotalPublishingHousesByBook(id){
			return BaseService.get('/books/v1/publishingHouse/book', id)
		}
	}

		

/*
		BaseService.getAll(path + "/title/{title}").then(function(bookByTitleTotal) {
			$("#totalBookByTitle").text(bookByTitleTotal);
		});
	
		BaseService.getAll(path + "/genre/{genre}").then(function(bookByGenreTotal) {
			$("#totalBookByGenre").text(bookByGenreTotal);
		});
		
		BaseService.getAll(path + "/pubblicationDate/{pubblicationDate}").then(function(bookByPubblicationDateTotal) {
			$("#totalBookByPubblicationDate").text(bookByPubblicationDateTotal);
		});
		
		BaseService.getAll(path + "/numPages/{numPages}").then(function(bookByNumPagesTotal) {
			$("#totalBookByNumPages").text(bookByNumPagesTotal);
		});
		
		BaseService.getAll(path + "/authorId/{authorId}").then(function(bookByAuthorIdTotal) {
			$("#totalBookByAuthorId").text(bookByAuthorIdTotal);
		});
*/
