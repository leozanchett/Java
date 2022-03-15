package com.codecademy.goldmedal.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codecademy.goldmedal.model.GoldMedal;

public interface GoldMedalsRepository extends CrudRepository<GoldMedal, Long> {
	
	Integer countByCountry(final String countryName);
	Integer countBySeason(final String season);
	Integer findBySeasonOrderByYearAsc(final String season);
	Integer countByGenderAndCountry(final String gender, final String country);
	
	List<GoldMedal> findByCountryAndSeasonOrderByYearAsc(final String country, final String season);
	List<GoldMedal> findByCountryAndSeason(final String country, final String season);
}
