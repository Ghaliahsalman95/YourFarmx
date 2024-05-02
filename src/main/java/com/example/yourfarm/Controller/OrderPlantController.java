package com.example.yourfarm.Controller;

import com.example.yourfarm.Service.AuthService;
import com.example.yourfarm.Service.OrderPlantService;
import jakarta.validation.Valid;import com.example.yourfarm.Model.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;import com.example.yourfarm.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/OrderPlant")
@RequiredArgsConstructor
public class OrderPlantController {
    private final OrderPlantService orderPlantService;
    private final AuthService authService;
    Logger logger = LoggerFactory.getLogger(OrderFarmerController.class);

//ADMIN
    @GetMapping("/get")
    public ResponseEntity getOrderPlant(){
        logger.info("get OrderPlant");
        return ResponseEntity.ok(orderPlantService.getAllOrderPlant());
    }

    //-------------------------------------   end CRUD  ---------------------------
   //kh
    @PutMapping("/update-order-plant/{orderId}")
    public ResponseEntity updateStatusOrderPlant( AuthenticationPrincipal User user, Integer farmId, @PathVariable Integer orderId){
        orderPlantService.updateStatusOrderPlant(user.getId(),orderId);
        return ResponseEntity.status(200).body("update Status Order Plant Successful");

    }

    //kh
    @PutMapping("/reject-order-plant/{orderId}")
    public ResponseEntity rejectOrderPlant(AuthenticationPrincipal User user,@PathVariable Integer orderId){
        orderPlantService.rejectOrderPlant(user.getId(),orderId);
        return ResponseEntity.status(200).body("reject Order Plant Successful");

    }


   //kh
    @PutMapping("/accept-order-plant")
    public ResponseEntity acceptOrderPlant( @PathVariable  Integer farmId, @PathVariable Integer orderId){
        orderPlantService.acceptOrderPlant(farmId,orderId);
        return ResponseEntity.status(200).body("accept Order Plant Successful");

    }





}
