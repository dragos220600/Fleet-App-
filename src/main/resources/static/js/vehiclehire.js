/**
 * 
 */
 
$('document').ready(function(){	
	$('table #editButton').on('click',function(event){
		event.preventDefault();			
		var href = $(this).attr('href');	
			
		$.get(href, function(vehicleHire, status){
			
			$('#idEdit').val(vehicleHire.id);
			$('#ddlVehicleHireEdit').val(vehicleHire.vehicleid);			

			var dateOut = vehicleHire.dateOut.substr(0,10);			
			$('#dateOutEdit').val(dateOut);

			var dateIn = vehicleHire.dateIn.substr(0,10);	
			$('#dateInEdit').val(dateIn);
			
			$('#vehicleHireClientEdit').val(vehicleHire.clientid);	
			$('#vehicleHireEmployeeEdit').val(vehicleHire.employeeid);		

		});					
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleHire, status){
			$('#idDetails').val(vehicleHire.id);
			$('#ddlVehicleHireDetails').val(vehicleHire.vehicleid);			

			var dateOut = vehicleHire.dateOut.substr(0,10);			
			$('#dateOutDetails').val(dateOut);

			var dateIn = vehicleHire.dateIn.substr(0,10);	
			$('#dateInDetails').val(dateIn);
			
			$('#vehicleHireClientDetails').val(vehicleHire.clientid);			
			$('#vehicleHireEmployeeDetails').val(vehicleHire.employeeid);		

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