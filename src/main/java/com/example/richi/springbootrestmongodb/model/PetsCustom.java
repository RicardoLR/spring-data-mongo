package com.example.richi.springbootrestmongodb.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class PetsCustom {

	@Id
	public String _id;
	public String name;
	public String species;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}

	public PetsCustom() {
		super();
	}

	public PetsCustom(String get_id, String name, String species) {
		super();
		this._id = get_id;
		this.name = name;
		this.species = species;	
	}


}
