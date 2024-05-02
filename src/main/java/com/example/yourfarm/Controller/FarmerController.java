package com.example.yourfarm.Controller;

import com.example.yourfarm.API.ApiResponse;
import com.example.yourfarm.DTO.FarmerDTO;
import com.example.yourfarm.Model.Farm;
import com.example.yourfarm.Model.Farmer;
import com.example.yourfarm.Model.User;
import com.example.yourfarm.Service.FarmerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Farmer")
@RequiredArgsConstructor
public class FarmerController {

    private final FarmerService farmerService;

    Logger logger = LoggerFactory.getLogger(FarmController.class);
//ALL
    @GetMapping("/farmers")
    public ResponseEntity getAllFarmers(){
        logger.info("get all farmers");
        return ResponseEntity.ok(farmerService.getAllFarmer());
    }
//ALL
    @PostMapping("/register")
    public ResponseEntity registerFarmer(@RequestBody @Valid FarmerDTO farmerDTO){
        farmerService.register(farmerDTO);
        logger.info("farmer registered");
        return ResponseEntity.ok(new ApiResponse("farmer registered"));
    }
//FARMER
    @PutMapping("/update")
    public ResponseEntity updateFarmer(@AuthenticationPrincipal User user, @RequestBody @Valid FarmerDTO farmerDTO){
        farmerService.update(user.getFarmer().getId(), farmerDTO);
        logger.info("farmer updated");
        return ResponseEntity.ok(new ApiResponse("farmer updated"));
    }
//ADMIN
    @DeleteMapping("/delete/{farmer_id}")
    public ResponseEntity deleteFarmer(@AuthenticationPrincipal User user, @PathVariable Integer farmer_id){
        farmerService.deleteFarmer(farmer_id);
        logger.info("farmer_id");
        return ResponseEntity.ok(new ApiResponse("farmer deleted"));
    }

    //-------------------------------------   end CRUD  ---------------------------


    //Farm
    @GetMapping("/New Orders")
    public ResponseEntity NewOrdersToFarmer(@AuthenticationPrincipal Farmer farmer){
        logger.info("get all New Orders To Farmer");
        return ResponseEntity.ok(farmerService.NewOrdersToFarmer(farmer.getId()));
    }

    //Farm
    @GetMapping("/currentOrders")
    public ResponseEntity currentContract(@AuthenticationPrincipal Farm farm){
        logger.info("get all current Orders To Farmer");
        return ResponseEntity.ok(farmerService.currentOrdersToFarmer(farm.getId()));
    }

    //Farm
    @GetMapping("/previousOrders")
    public ResponseEntity previousOrdersToFarmer(@AuthenticationPrincipal Farm farm){
        logger.info("get all previous Orders To Farmer");
        return ResponseEntity.ok(farmerService.previousOrdersToFarmer(farm.getId()));
    }
}
