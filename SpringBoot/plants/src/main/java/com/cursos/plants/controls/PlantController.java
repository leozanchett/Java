package com.cursos.plants.controls;

import com.cursos.plants.entities.Plant;
import com.cursos.plants.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @PostMapping("/plants")
    public Plant createNewPlant(@RequestBody Plant plant){
        return plantRepository.save(plant);
    }

    @PutMapping("/plants/{id}")
    public Plant updatePlant(@PathVariable("id") Integer id, @RequestBody Plant p){
        Optional<Plant> plantToUpdateOptional = plantRepository.findById(id);
        if(plantToUpdateOptional.isPresent()){
            Plant plantToUpdate = plantToUpdateOptional.get();
            if(p.getName() != null){
                plantToUpdate.setName(p.getName());
            }
            if(p.getHasFruit() != null){
                plantToUpdate.setHasFruit(p.getHasFruit());
            }
            if(p.getQuantity() != null){
                plantToUpdate.setQuantity(p.getQuantity());
            }
            if(p.getWateringFrequency() != null){
                plantToUpdate.setWateringFrequency(p.getWateringFrequency());
            }
            return plantRepository.save(plantToUpdate);
        }else{
            return null;
        }
    }
}
