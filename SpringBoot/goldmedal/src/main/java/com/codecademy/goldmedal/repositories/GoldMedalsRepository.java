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
	List<GoldMedal> findAllByCountryOrderByYearAsc(final String country);
	List<GoldMedal> findAllByCountryOrderByYearDesc(final String country);
	List<GoldMedal> findAllByCountryOrderBySeasonAsc(final String country);
	List<GoldMedal> findAllByCountryOrderBySeasonDesc(final String country);
	List<GoldMedal> findAllByCountryOrderByCityAsc(final String country);
	List<GoldMedal> findAllByCountryOrderByCityDesc(final String country);
	List<GoldMedal> findAllByCountryOrderByNameAsc(final String country);
	List<GoldMedal> findAllByCountryOrderByNameDesc(final String country);
	List<GoldMedal> findAllByCountryOrderByEventAsc(final String country);
	List<GoldMedal> findAllByCountryOrderByEventDesc(final String country);
	}
