$(document).ready(function() {
	BookService.getTotals();
	
	$('#btnShow').click(function() {
		BookService.getAll();
	});

	$('#btnAdd').click(function() {
		$('table').empty();
		$('table').hide();
		$('#saveForm').show();
	})

	$('#saveForm').submit(function(event) {
		event.preventDefault();

		var bookId = document.getElementById('bookId').value
		var bookAuthorId = document.getElementById('bookAuthorId').value;
		var bookTitle = document.getElementById('bookTitle').value;
		var bookGenre = document.getElementById('bookGenre').value;
		var bookPubblicationDate = document.getElementById("bookPubblicationDate").value;
		var bookNumPages = document.getElementById("bookNumPages").value;

		var formData = {
			'bookId': bookId,
			'bookAuthorId': bookAuthorId,
			'bookTitle': bookTitle,
			'bookGenre':bookGenre,
			'bookPubblicationDate':bookPubblicationDate,
			'bookNumPages': bookNumPages
		};

		var action;
		if (bookId) {
			formData.bookId = bookId;
			action = BookService.put;
		} else {
			action = BookService.post;
		}
		action(JSON.stringify(formData))
	});
});