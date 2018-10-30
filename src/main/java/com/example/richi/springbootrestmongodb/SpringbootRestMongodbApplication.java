package com.example.richi.springbootrestmongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.richi.springbootrestmongodb.model.Pets;
import com.example.richi.springbootrestmongodb.repository.PetsRepository;

import org.springframework.boot.CommandLineRunner;

/**
	db.pets.deleteMany({})
	db.pets.insertMany([{ "name" : "Spot", "species" : "dog", "breed" : "pitbull" }, { "name" : "Daisy", "species" : "cat", "breed" : "calico" }, { "name" : "Bella", "species" : "dog", "breed" : "australian shepard" } ]);
	db.pets.insertMany([{ "name" : "choplin", "species" : "dog", "breed" : "pitbull", "edad":1, "edadDueno":10 }, { "name" : "Nose", "species" : "cat", "breed" : "calico", "edad":10, "edadDueno":100 }, { "name" : "arte", "species" : "dog", "breed" : "australian shepard", "edad":100, "edadDueno":1000 } ]);
 *
 */
@SpringBootApplication
@EnableMongoRepositories("com.example.richi")
public class SpringbootRestMongodbApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestMongodbApplication.class, args);
	}


	@Autowired
	private PetsRepository repository;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("-------------------------------");
		for (Pets customer : this.repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();
	}

}
