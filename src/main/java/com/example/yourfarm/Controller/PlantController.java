package com.example.yourfarm.Controller;

import com.example.yourfarm.API.ApiResponse;
import com.example.yourfarm.DTO.CustomerDTO;
import com.example.yourfarm.Model.Company;
import com.example.yourfarm.Model.Farm;
import com.example.yourfarm.Model.Plant;
import com.example.yourfarm.Model.User;
import com.example.yourfarm.Service.PlantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Plant")
@RequiredArgsConstructor
public class PlantController {
    private final PlantService plantService;
    Logger logger = LoggerFactory.getLogger(PlantController.class);

//ALL
    @GetMapping("/get")
    public ResponseEntity getAllPlant(){
        logger.info("get all Plant");
        return ResponseEntity.ok(plantService.getAllPlant());
    }

//FARM
    @PostMapping("/add")
    public ResponseEntity addPlant(@AuthenticationPrincipal Farm farm, @RequestBody @Valid Plant plant){
        plantService.addPlant(farm.getId(),plant);
        return ResponseEntity.ok(new ApiResponse("Add plant"));
    }

//FARM
    @PutMapping("/update/{plantId}")
    public ResponseEntity updatePlant(@AuthenticationPrincipal Farm farm,@PathVariable Integer plantId, @RequestBody @Valid Plant plant){
        plantService.update(farm.getId(),plantId,plant);
        logger.info("Plant updated");
        return ResponseEntity.ok(new ApiResponse("Plant update"));
    }
//FARM
    @DeleteMapping("/delete/{plantId}")
    public ResponseEntity deletePlant(@AuthenticationPrincipal Farm farm,@PathVariable Integer plantId){
        plantService.deletePlant(farm.getId(),plantId);
        logger.info("Plant deleted");
        return ResponseEntity.ok(new ApiResponse("Plant deleted"));
    }
    //-------------------------------------   end CRUD  ---------------------------
    //All
    @GetMapping("/plantOfFarm/{farmName}")
    public ResponseEntity Contract(@PathVariable String farmName){
        logger.info("get all Plant Of Farm");
        return ResponseEntity.ok(plantService.ViewPlantOfFarm(farmName));
    }

    @PostMapping("/add")
    public ResponseEntity addPlant(@AuthenticationPrincipal Plant plant,@PathVariable Integer farmId){
        plantService.addPlant(farmId,plant);
        return ResponseEntity.ok(new ApiResponse("Plant added"));
    }

    @GetMapping("/plants/{name}")
    public ResponseEntity getPlantByName(@AuthenticationPrincipal Plant plant, @PathVariable String name) {
        return ResponseEntity.ok(plantService.findPlantByName(name));
    }
}
