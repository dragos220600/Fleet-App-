/**
 * 
 */
 
$('document').ready(function(){	
	$('table #editButton').on('click',function(event){
		event.preventDefault();			
		var href = $(this).attr('href');	
			
		$.get(href, function(vehicleMovement, status){
			
			$('#idEdit').val(vehicleMovement.id);
			$('#ddlVehicleEdit').val(vehicleMovement.vehicleid);			
			$('#ddlLocation1Edit').val(vehicleMovement.locationid1);
			
			var departureDate = vehicleMovement.date1.substr(0,10);			
			$('#date1Edit').val(departureDate);
		
			$('#ddlLocation2Edit').val(vehicleMovement.locationid2);
			
			var arrivalDate = vehicleMovement.date2.substr(0,10);	
			$('#date2Edit').val(arrivalDate);
			
			$('#remarksEdit').val(vehicleMovement.remarks);
			
		});					
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleMovement, status){
			$('#idDetails').val(vehicleMovement.id);
			$('#ddlVehicleDetails').val(vehicleMovement.vehicleid);
			$('#ddlLocation1Details').val(vehicleMovement.locationid1);
			
			var departureDate = vehicleMovement.date1.substr(0,10);			
			$('#date1Details').val(departureDate);
		
			$('#ddlLocation2Details').val(vehicleMovement.locationid2);
			
			var arrivalDate = vehicleMovement.date2.substr(0,10);	
			$('#date2Details').val(arrivalDate);
			
			$('#remarksDetails').val(vehicleMovement.remarks);
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