package com.codecademy.goldmedal.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.codecademy.goldmedal.model.Country;

public interface CountriesRepository extends CrudRepository<Country, Long> {
	
	Optional<Country> findByName(final String name);
	List<Country> findAllByOrderByNameAsc();
	List<Country> findAllByOrderByNameDesc();
	List<Country> findAllByOrderByGdpAsc();
	List<Country> findAllByOrderByGdpDesc();
	List<Country> findAllByOrderByPopulationAsc();
	List<Country> findAllByOrderByPopulationDesc();
}
