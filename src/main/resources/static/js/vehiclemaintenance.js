/**
 * 
 */
 
$('document').ready(function(){	
	$('table #editButton').on('click',function(event){
		event.preventDefault();			
		var href = $(this).attr('href');	
			
		$.get(href, function(vehicleMaintenance, status){
			
			$('#idEdit').val(vehicleMaintenance.id);
			$('#ddlVehicleEdit').val(vehicleMaintenance.vehicleid);			

			var startDate = vehicleMaintenance.startDate.substr(0,10);			
			$('#startDateEdit').val(startDate);
		
			var endDate = vehicleMaintenance.endDate.substr(0,10);	
			$('#endDateEdit').val(endDate);
			
			$('#remarksEdit').val(vehicleMaintenance.remarks);
			$('#ddlSupplierEdit').val(vehicleMaintenance.supplierid);
			$('#priceEdit').val(vehicleMaintenance.price);

		});					
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleMaintenance, status){
			$('#idDetails').val(vehicleMaintenance.id);
			$('#ddlVehicleDetails').val(vehicleMaintenance.vehicleid);			

			var startDate = vehicleMaintenance.startDate.substr(0,10);			
			$('#startDateDetails').val(startDate);
		
			var endDate = vehicleMaintenance.endDate.substr(0,10);	
			$('#endDateDetails').val(endDate);
			
			$('#remarksDetails').val(vehicleMaintenance.remarks);
			$('#ddlSupplierDetails').val(vehicleMaintenance.supplierid);
			$('#priceDetails').val(vehicleMaintenance.price);
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