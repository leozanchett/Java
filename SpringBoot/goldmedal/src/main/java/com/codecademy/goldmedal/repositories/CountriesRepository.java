package com.codecademy.goldmedal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codecademy.goldmedal.model.Country;

public interface CountriesRepository extends CrudRepository<Country, Integer> {
	
	
}
