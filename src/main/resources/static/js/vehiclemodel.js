$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
			
		var href = $(this).attr('href');
		
		$.get(href, function(vehiclemodel, status){
			$('#idEdit').val(vehiclemodel.id);
			$('#descriptionEdit').val(vehiclemodel.description);
			$('#detailsEdit').val(vehiclemodel.details);
		});					
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehiclemodel, status){
			$('#idDetails').val(vehiclemodel.id);
			$('#descriptionDetails').val(vehiclemodel.description);
			$('#detailsDetails').val(vehiclemodel.details);
			$('#createdByDetails').val(vehiclemodel.createdBy);
			$('#createdDateDetails').val(vehiclemodel.createdDate.substr(0,19).replace("T", " "));
			$('#lastModifiedByDetails').val(vehiclemodel.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehiclemodel.lastModifiedDate.substr(0,19).replace("T", " "));
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