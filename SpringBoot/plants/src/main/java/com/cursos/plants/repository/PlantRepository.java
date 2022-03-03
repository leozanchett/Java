package com.cursos.plants.repository;

import com.cursos.plants.entities.Plant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlantRepository extends CrudRepository<Plant, Integer> {

    public List<Plant> findByHasFruitTrue();
}
