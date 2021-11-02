package com.fleetapp.fleetapp.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CommonObject extends Auditable<String>{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private String details;
	
	public CommonObject() {
		
	}
	
	public CommonObject(Integer id, String description, String details) {
		this.id = id;
		this.description = description;
		this.details = details;
	}
	
	/*
	 * no lombok here bc. is not an Entity but a MappedSuperclass.
	 * Designates a class whose mapping information is applied to the entities that inherit from it. 
	 * A mapped superclass has no separate table defined for it.
		A class designated with the MappedSuperclass annotation 
		can be mapped in the same way as an entity except that the mappings will 
		apply only to its subclasses since no table exists for the mapped superclass 
		itself. When applied to the subclasses the inherited mappings will apply
		 in the context of the subclass tables. Mapping information may be overridden
		  in such subclasses by using the AttributeOverride and AssociationOverride annotations or corresponding XML elements. 
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "CommonObject [id=" + id + ", description=" + description + ", details=" + details + "]";
	}
	
	
}
