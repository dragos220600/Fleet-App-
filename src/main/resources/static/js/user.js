
$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(user, status){
			$('#idEdit').val(user.id);
			$('#usernameEdit').val(user.username);
			$('#passwordEdit').val(user.password);
		});			
		$('#editModal').modal();		
	});

		$('.table #detailsButton').on('click',function(event) {
			event.preventDefault();		
			var href= $(this).attr('href');		
			$.get(href, function(user, status){
			$('#idDetails').val(user.id);
			$('#usernameDetails').val(user.username);
			$('#passwordDetails').val(user.password);
				//$('#lastModifiedByDetails').val(client.lastModifiedBy);
				//$('#lastModifiedDateDetails').val(client.lastModifiedDate.substr(0,19).replace("T", " "));
			});			
			$('#detailsModal').modal();		
		});	
		
		$('.table #deleteButton').on('click',function(event) {
			event.preventDefault();
			var href = $(this).attr('href');
			$('#confirmDeleteButton').attr('href', href);
			$('#deleteModal').modal();		
		});	

});