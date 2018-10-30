package com.example.richi.springbootrestmongodb.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.richi.springbootrestmongodb.model.Pets;
import com.example.richi.springbootrestmongodb.model.PetsCustom;
import com.example.richi.springbootrestmongodb.repository.PetsRepository;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/pets")
public class PetsController {

	@Autowired
	private PetsRepository repository;

	/**
	 * Idea de filtrar algunos elementos del JSON con nombre y species
	 * 
	 * no muy buena usar @jsonignore
	 * @return
	 */
	@RequestMapping(value = "/petscustom", method = RequestMethod.GET)
	public List<PetsCustom> getAllPetsCustom() {
		System.out.println("getAllPets");
		
		List<PetsCustom> petsCustom = new ArrayList<PetsCustom>(); 
		
		for (Pets i : repository.findAll2()) {
			petsCustom.add( new PetsCustom( i.get_id() , i.getName(), i.getSpecies() )  );
		}
		
		return petsCustom;
	}
	
	/**
	 * Uso de jsonignore con query y fields
	 * @return
	 */
	@RequestMapping(value = "/sin-name-species", method = RequestMethod.GET)
	public List<Pets> getAllPets() {
		System.out.println("getAllPets");

		return repository.findAll2();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Pets> getAllPet() {
		System.out.println("getAllPets");

		return repository.findAll();
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Pets getPetById(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Pets pets) {
		pets.set_id(id);
		repository.save(pets);
	}
	
	
	/**
	 * Bsuqueda custom de data
	 * 
	 */
	@RequestMapping(value = "/igual", method = RequestMethod.GET)
	public Pets getAllPetsEquals() {
		return repository.findByNameQuery("Spot");
//		seria igual
//		return repository.findByNameQuery("Spot");

	}
	
	
	@RequestMapping(value = "/campos", method = RequestMethod.GET)
	public List<Pets> getFindBypetNameJustReturnNameQuery() {
		return repository.findBypetNameJustReturnNameQuery("Spot");
//		seria igual
//		return repository.findByNameQuery("Spot");

	}
	
	
	
	@RequestMapping(value = "/noigual", method = RequestMethod.GET)
	public List<Pets> getAllPetsNoEquals() {
		return repository.findByNameNot("Spot");
//		seria igual
//		return repository.findByNameNotQuery("Spot");

	}
	
	


}