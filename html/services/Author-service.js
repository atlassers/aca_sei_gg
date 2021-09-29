const path = '/authors/v1'

class AuthorService {
	constructor() { }

	static getTotals() {
		BaseService.getAll(path + "/total").then(function(authorTotal) {
			$("#totalAuthor").text(authorTotal)
		});

		BaseService.getAll(path + "/total-undeleted").then(function(authorValidTotal) {
			$("#totalAuthorValid").text(authorValidTotal);
		});

		BaseService.getAll(path + "/total-deleted").then(function(authorNotValidTotal) {
			$("#totalAuthorNotValid").text(authorNotValidTotal);
		});
	}
	
	static getAll() {
		BaseService.getAll(path)
			.then(function(bookDtoList) {
				var content = '<table class="aca-fill>"';
				content += '<tr>'
					+ '<th scope= "col">AuthorId</th>'
					+ '<th scope="col">Name</th>'
					+ '<th scope="col">Country</th>'
					+ '<th scope="col">BirthDate</th>'
					+ '<th scope="col">Gender</th>'
					+ '</tr>';
					
					jQuery.each(bookDtoList, function(i, val) {
					content += '<tr>'
						+ '<td>' + val.authorId + '</td>'
						+ '<td>' + val.authorName + '</td>'
						+ '<td>' + val.authorCountry + '</td>'
						+ '<td>' + val.authorBirthDate + '</td>'
						+'<td>' + val.authorGender + '</td>'
						+ '<td><button id="btnDetail-' + val.authorId + '" class="btn btn-warning" onclick="AuthorService.detail(' + val.authorId + ')">detail</button></td>'
						+ '<td><button id="btnDelete-' + val.authorId + '" class="btn btn-danger" onclick="AuthorService.delete(' + val.authorId + ')">delete</button></td>'
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
			.then(function(authorDto) {
				window.alert("The book has been registered")
				$('#saveForm').trigger('reset');
				$('#saveForm').hide();

				AuthorService.getAll();
				AuthorService.getTotals();
			});
	}
	
	static delete(id) {
		BaseService.delete(path, id)
			.then(function(result) {
				window.alert('Author' + id + ' successfully deleted!')

				BookService.getAll();
				BookService.getTotals();
			});
	}			
	
	
		static detail(id) {
		BaseService.get('/authors/v1', id)
			.then(function(authorDto) {
				// il bookId  corrisponda all' input id del div a riga 106 dell'html così gli altri
				// inoltre occhio perchè avevo scritto id invece di bookId in bookDto.bookId, quindi non lo pescava
				document.getElementById('authorId').value = authorDto.authorId;
				document.getElementById('authorName').value = authorDto.authorName;
				document.getElementById('authorCountry').value = authorDto.authorCountry;
				document.getElementById("authorBirthDate").value = authorDto.authorBirthDate;
				document.getElementById("authorGender").value = authorDto.authorGender;
				

				$('.table').empty();
				$('.table').hide();
				$('#saveForm').show();
			});
		}
		
	}				
					
					
