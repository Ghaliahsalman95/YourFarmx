package com.example.yourfarm.Controller;

import com.example.yourfarm.API.ApiResponse;
import com.example.yourfarm.DTO.CustomerDTO;
import com.example.yourfarm.Model.User;
import com.example.yourfarm.Service.OrderGuidanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/OrderGuidance")
@RequiredArgsConstructor
public class OrderGuidanceController {
    private final OrderGuidanceService orderGuidanceService;
    Logger logger = LoggerFactory.getLogger(OrderGuidanceController.class);

//ADMIN
    @GetMapping("/get")
    public ResponseEntity getOrderGuidance(){
        logger.info("get Order Guidance");
        return ResponseEntity.ok(orderGuidanceService.getAllOrderGuidance());
    }



    //-------------------------------------   end CRUD  ---------------------------
}
