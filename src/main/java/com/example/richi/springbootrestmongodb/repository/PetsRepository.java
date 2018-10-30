package com.example.richi.springbootrestmongodb.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.richi.springbootrestmongodb.model.Pets;

@Repository
public interface PetsRepository extends MongoRepository<Pets, String> {

	public Pets findBy_id(ObjectId _id);

	//	public ObjectId _id;
	//	public String name;
	//	public String species;
	//	public String breed;

	@Query(value = "{}", fields = "{'name':0, 'species':0, 'edad':0}")
    List<Pets> findAll2();
	
	
//	@Query(value = "{ $or: [ { 'name' : ?0 }, { 'species' : ?0 } ] }")
//    Page<Pets> queryByNameOrSpecies(String query, Pageable pageable);
//	
	
	//------------------------------------------- equality
	public Pets findByName(String name);

	@Query(value="{'name':?0}", fields="{ 'species' : 0 }")
	public Pets findByNameQuery(String name);

	//------------------------------------------- not equal

	public List<Pets> findByNameNot(String PetsName);

	@Query("{name : {$ne : ?0}}")
	public List<Pets> findByNameNotQuery(String PetsName);



	//------------------------------------------- like / regex

	public List<Pets> findByNameLike(String PetsName);

	public List<Pets> readByNameRegex(String PetsName);

	@Query("{name : {$regex : ?0}}")
	public List<Pets> getByNameRegexQuery(String PetsName);

	//------------------------------------------- nested

	// public List<Pets> findByPetName(String petName);

	@Query("{'pets.name' : ?0}")
	public List<Pets> findBypetNameQuery(String petName);

	//------------------------------------------- null / not null

	// public List<Pets> findByPopulationIsNull();

	@Query("{'population' : null}")
	public List<Pets> findByPopulationIsNullQuery();

	// public List<Pets> findByPopulationIsNotNull();

	@Query("{'population' : {$ne : null}}")
	public List<Pets> findByPopulationIsNotNullQuery();

	//------------------------------------------- less than / greater than

	// public List<Pets> findByEdadInSquareMilesLessThan(int edad);

	@Query("{'edad' : {$lt : ?0}}")
	public List<Pets> findByEdadInSquareMilesLessThanQuery(int edad);

	public List<Pets> findByEdadGreaterThan(int edad);

	@Query("{'edad' : {$gt : ?0}}")
	public List<Pets> findByPopulationGreaterThanQuery(int population);

	//------------------------------------------- between

	public List<Pets> findByEdadBetween(int start, int end);

	@Query("{'edad' : {$gt : ?0, $lt : ?1}}")
	public List<Pets> findByEdadBetweenQuery(int start, int end);

	//------------------------------------------- and

	public List<Pets> findByNameAndEdadLessThan(String petName, int pop);

	@Query("{'pets.name' : ?0, population : {$lt : ?1}}")
	public List<Pets> findByNameAndLessThanQuery(String petName, int pop);

	//------------------------------------------- or

	public List<Pets> findByEdadLessThanOrEdadDuenoLessThan(int edad, int edadDueno);

	@Query("{'$or' : [{'population' : {$lt : ?0}}, {'edad' : {$lt : ?1}}]}")
	public List<Pets> findByEdadLessThanOrEdadDuenoLessThanQuery(int edad, int edadDueno);

	//------------------------------------------- order by

	public List<Pets> findByNameOrderByEdadDesc(String name);

	//------------------------------------------- fields

	@Query(value="{'pets.name' : ?0}", fields="{_id : 0, name : 1}")
	public List<Pets> findBypetNameJustReturnNameQuery(String ame);



}