package com.example.yourfarm.Controller;

import com.example.yourfarm.API.ApiResponse;
import com.example.yourfarm.DTO.FarmDTO;
import com.example.yourfarm.Model.Company;
import com.example.yourfarm.Model.Farm;
import com.example.yourfarm.Model.User;
import com.example.yourfarm.Service.FarmService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Farm")
@RequiredArgsConstructor
public class FarmController {
    private final FarmService farmService;

    Logger logger = LoggerFactory.getLogger(FarmController.class);

//ALL
    @GetMapping("/farms")
    public ResponseEntity getAllFarm(){
        logger.info("get all farm");
        return ResponseEntity.ok(farmService.getAllFarm());
    }

//ALL
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid FarmDTO farmDTO){
        farmService.register(farmDTO);
        logger.info("farm registered");
        return ResponseEntity.ok(new ApiResponse("farm registered"));
    }

//FARM
    @PutMapping("/update")
    public ResponseEntity updateFarm(@AuthenticationPrincipal User user, @RequestBody @Valid FarmDTO farmDTO){
        farmService.update(user.getFarm().getId(), farmDTO);
        logger.info("farm updated");
        return ResponseEntity.ok(new ApiResponse("farm updated"));
    }
//ADMIN
    @DeleteMapping("/delete/{farm_id}")
    public ResponseEntity deleteFarm(@AuthenticationPrincipal User user, @PathVariable Integer farm_id){
        farmService.deleteFarm(farm_id);
        logger.info("farm deleted");
        return ResponseEntity.ok(new ApiResponse("farm deleted"));
    }
//-------------------------------------   end CRUD  ---------------------------

    //Farm
@GetMapping("/NewPlantOrders")
public ResponseEntity NewPlantOrders(@AuthenticationPrincipal Farm farm){
    logger.info("get all New Plant Orders");
    return ResponseEntity.ok(farmService.NewPlantOrders(farm.getId()));
}

    //Farm
    @GetMapping("/currentPlantOrders")
    public ResponseEntity currentPlantOrders(@AuthenticationPrincipal Farm farm){
        logger.info("get all current Plant Orders");
        return ResponseEntity.ok(farmService.currentPlantOrders(farm.getId()));
    }
    //Farm
    @GetMapping("/previousPlantOrders")
    public ResponseEntity previousPlantOrders(@AuthenticationPrincipal Farm farm){
        logger.info("get all previous Plant Orders");
        return ResponseEntity.ok(farmService.previousPlantOrders(farm.getId()));
    }

    //Farm
    @GetMapping("/NewContract")
    public ResponseEntity NewContract(@AuthenticationPrincipal Farm farm){
        logger.info("get all New Contract");
        return ResponseEntity.ok(farmService.NewContract());
    }

    //Farm
    @GetMapping("/currentContract")
    public ResponseEntity currentContract(@AuthenticationPrincipal Farm farm){
        logger.info("get all current Contract");
        return ResponseEntity.ok(farmService.currentContract(farm.getId()));
    }

    //Farm
    @GetMapping("/previousContract")
    public ResponseEntity previousContract(@AuthenticationPrincipal Farm farm){
        logger.info("get all previous Contract");
        return ResponseEntity.ok(farmService.previousContract(farm.getId()));
    }


    //Farm kh
    @PutMapping("/acceptContract")
    public ResponseEntity acceptContract(@AuthenticationPrincipal User user, @PathVariable  Integer farmId, @PathVariable Integer orderId){
        farmService.acceptContract(farmId, orderId);
        return ResponseEntity.status(200).body("accept contract Successfully");

    }

}
