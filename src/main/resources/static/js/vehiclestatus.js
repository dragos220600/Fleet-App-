$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
			
		var href = $(this).attr('href');
		
		$.get(href, function(vehicletype, status){
			$('#idEdit').val(vehicletype.id);
			$('#descriptionEdit').val(vehicletype.description);
			$('#detailsEdit').val(vehicletype.details);
		});					
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicletype, status){
			$('#idDetails').val(vehicletype.id);
			$('#descriptionDetails').val(vehicletype.description);
			$('#detailsDetails').val(vehicletype.details);
			//$('#lastModifiedByDetails').val(vehicletype.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(vehicletype.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeleteButton').attr('href', href);
		
		$('#deleteModal').modal();
	});
		
});