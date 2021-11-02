
$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(client, status){
			$('#txtAddressEdit').val(client.address);
			$('#txtCityEdit').val(client.city);
			$('#ddlCountryEdit').val(client.countryid);
			$('#txtDetailsEdit').val(client.details);
			$('#txtEmailEdit').val(client.email);
			$('#txtIdEdit').val(client.id);
			$('#txtMobileEdit').val(client.mobile);
			$('#txtNameEdit').val(client.name);	
			$('#txtPhoneEdit').val(client.phone);			
			$('#ddlStateEdit').val(client.stateid);	
			$('#txtWebsiteEdit').val(client.website);
		});			
		$('#editModal').modal();		
	});

		$('.table #detailsButton').on('click',function(event) {
			event.preventDefault();		
			var href= $(this).attr('href');		
			$.get(href, function(client, status){
				$('#idDetails').val(client.id);
				$('#addressDetails').val(client.address);
				$('#cityDetails').val(client.city);
				$('#ddlCountryDetails').val(client.countryid);
				$('#detailsDetails').val(client.details);
				$('#emailDetails').val(client.email);
				//$('#idDetails').val(client.id);
				$('#mobileDetails').val(client.mobile);
				$('#nameDetails').val(client.name);	
				$('#phoneDetails').val(client.phone);			
				$('#ddlStateDetails').val(client.stateid);	
				$('#websiteDetails').val(client.website);
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