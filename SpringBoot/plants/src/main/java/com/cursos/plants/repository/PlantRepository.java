package com.cursos.plants.repository;

import com.cursos.plants.entities.Plant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlantRepository extends CrudRepository<Plant, Integer> {

    public List<Plant> findByHasFruitTrue();

    public List<Plant> findByHasFruitFalse();

    public List<Plant> findByQuantityLessThan(Integer quantity);

    public List<Plant> findByHasFruitTrueAndQuantityLessThan(Integer quantity);

    public List<Plant> findByHasFruitFalseAndQuantityLessThan(Integer quantity);
}
