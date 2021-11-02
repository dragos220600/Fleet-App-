
$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		
		
		event.preventDefault(); /*default is JSON format but this line has no effect*/ 
			
			//get URL "/countries/findById/?id=1"
			//to get Attribute of edit button,
			var href = $(this).attr('href');			
			
		//make request 			
		$.get(href, function(country, status){ //callback function returning particular record into input boxes
			$('#idEdit').val(country.id);
			$('#descriptionEdit').val(country.description);
			$('#capitalEdit').val(country.capital);
			$('#codeEdit').val(country.code);
			$('#continentEdit').val(country.continent);
			$('#nationalityEdit').val(country.nationality);
		});						
		$('#editModal').modal();
	});
	
		$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(country, status){
			$('#idDetails').val(country.id);
			$('#ddlCountryDetails').val(country.countryid);
			$('#capitalDetails').val(country.capital);
			$('#codeDetails').val(country.code);
			$('#nationalityDetails').val(country.nationality);
			$('#continentDetails').val(country.continent);
			$('#nameDetails').val(country.name);
			$('#detailsDetails').val(country.details);
			$('#descriptionDetails').val(country.description);
			//$('#lastModifiedByDetails').val(state.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	
	$('table #deleteButton').on('click', function(event){
		event.preventDefault();		
		var href= $(this).attr('href');		
		$('#confirmDeleteButton').attr('href', href);		
		$('#deleteModal').modal();
	});
		
});