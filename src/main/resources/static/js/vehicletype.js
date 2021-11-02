$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
			
		var href = $(this).attr('href');
		
		$.get(href, function(vehiclestatus, status){
			$('#idEdit').val(vehiclestatus.id);
			$('#descriptionEdit').val(vehiclestatus.description);
			$('#detailsEdit').val(vehiclestatus.details);
		});					
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehiclestatus, status){
			$('#idDetails').val(vehiclestatus.id);
			$('#descriptionDetails').val(vehiclestatus.description);
			$('#detailsDetails').val(vehiclestatus.details);
			$('#lastModifiedByDetails').val(vehiclestatus.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehiclestatus.lastModifiedDate.substr(0,19).replace("T", " "));
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