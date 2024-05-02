package com.example.yourfarm.Controller;

import com.example.yourfarm.API.ApiResponse;
import com.example.yourfarm.DTO.FarmerDTO;
import com.example.yourfarm.Model.User;
import com.example.yourfarm.Service.OrderFarmerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/OrderFarmer")
@RequiredArgsConstructor
public class OrderFarmerController {
    private final OrderFarmerService orderFarmerService;
    Logger logger = LoggerFactory.getLogger(OrderFarmerController.class);
//ADMIN
    @GetMapping("/get")
    public ResponseEntity getOrderFarmer(){
        logger.info("get all Order Farmer ");
        return ResponseEntity.ok(orderFarmerService.getAllOrderFarmer());
    }

    //-------------------------------------   end CRUD  ---------------------------
}
