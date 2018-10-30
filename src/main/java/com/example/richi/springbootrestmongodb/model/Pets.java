package com.example.richi.springbootrestmongodb.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.example.richi.springbootrestmongodb.filterjson.EdadFilter;

//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pets {
	
	@Id
	public ObjectId _id;
	public String name;
	
	/** 
	 * para toda clase o solo un elemento
	 */
	//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    @JsonInclude(JsonInclude.Include.NON_NULL)
	public String species; 
    
    public String breed;
	
	@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = EdadFilter.class)
	public int edad;
	
	@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = EdadFilter.class)
	public int edadDueno;


	// Constructors
	public Pets() {}

	public Pets(String name, String species) {
		this.name = name;
		this.species = species;
	}
	
	public Pets(ObjectId _id, String name, String species) {
		this._id = _id;
		this.name = name;
		this.species = species;
	}
	
	
	public Pets(ObjectId _id, String name, String species, String breed) {
		this._id = _id;
		this.name = name;
		this.species = species;
		this.breed = breed;
	}
	
	public Pets(ObjectId _id, String name, String species, String breed, int edad, int edadDueno) {
		this._id = _id;
		this.name = name;
		this.species = species;
		this.breed = breed;
		this.edad = edad;
		this.edadDueno = edadDueno;
	}

	// ObjectId needs to be converted to string
	public String get_id() { return _id.toHexString(); }
	public void set_id(ObjectId _id) { this._id = _id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getSpecies() { return species; }
	public void setSpecies(String species) { this.species = species; }

	public String getBreed() { return breed; }
	public void setBreed(String breed) { this.breed = breed; }

	public int getEdad() { return edad; }
	public void setEdad(int edad) { this.edad = edad; }
	
	public int getEdadDueno() { return edadDueno; }
	public void setEdadDueno(int edadDueno) { this.edadDueno = edadDueno; }
	
	
	@Override
	public String toString() {
		return "Pets [_id=" + _id + ", name=" + name + ", species=" + species + ", breed=" + breed + "]";
	}
	

}