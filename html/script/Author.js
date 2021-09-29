$(document).ready(function() {
	AuthorService.getTotals();
	
	$('#btnShow').click(function() {
		AuthorService.getAll();
	});

	$('#btnAdd').click(function() {
		$('table').empty();
		$('table').hide();
		$('#saveForm').show();
	})

	$('#saveForm').submit(function(event) {
		event.preventDefault();

		var authorId = document.getElementById('authorId').value
		var authorName = document.getElementById('authorName ').value;
		var authorCountry= document.getElementById('authorCountry').value;
		var authorBirthDate = document.getElementById("authorBirthDate").value;
		var authorGender = document.getElementById("authorGender").value;

		var formData = {
			'authorId': authorId,
			'authorName': authorName,
			'authorCountry': authorCountry,
			'authorBirthDate':authorBirthDate,
			'authorGender':authorGender,
		};

		var action;
		if (authorId) {
			formData.authorId = authorId;
			action = AuthorService.put;
		} else {
			action = AuthorService.post;
		}
		action(JSON.stringify(formData))
	});
});