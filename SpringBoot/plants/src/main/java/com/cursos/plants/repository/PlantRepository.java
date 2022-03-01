package com.cursos.plants.repository;

import com.cursos.plants.entities.Plant;
import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, Integer> {
}
