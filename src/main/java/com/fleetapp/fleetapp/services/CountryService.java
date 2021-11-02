package com.fleetapp.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleetapp.fleetapp.models.Country;
import com.fleetapp.fleetapp.repositories.CountryRepository;

@Service
public class CountryService {
	
	/*autowiring a bean into a service:
	It allows Spring to resolve and inject collaborating beans into our bean.
	The Spring framework enables automatic dependency injection.
	by declaring all the bean dependencies in a Spring configuration file, 
	Spring container can autowire relationships between collaborating beans. 
	This is called Spring bean autowiring.
	*/
	@Autowired
	private CountryRepository countryRepository;
	
	//Chapter 15: get Countries
	public List<Country> getCountries()
	{
		return countryRepository.findAll();//Interface JpaRepository<T,ID> Returns all entities sorted by the given options
	}
	
//	//Get All Countrys
	public List<Country> findAll(){
		return countryRepository.findAll();
	}	
	
	//Get Country By Id
	public Optional<Country> findById(int id) {
		return countryRepository.findById(id);
	}	
	
	//Delete Country
	public void delete(int id) {
		countryRepository.deleteById(id);
	}
	
	//Update Country
	public void save( Country country) {
		countryRepository.save(country);
	}

}
