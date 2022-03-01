package com.cursos.plants.controls;

import com.cursos.plants.entities.Plant;
import com.cursos.plants.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PlantController {

    @Autowired
    private PlantRepository plantRepository;

    public PlantController() {
    }

    @GetMapping("/plants")
    public Iterable<Plant> getAllPlants(){
        return  plantRepository.findAll();
    }

    @GetMapping("/plants/{id}")
    public Optional<Plant> getPlantById(@PathVariable("id") Integer id){
        return plantRepository.findById(id);
    }
}
