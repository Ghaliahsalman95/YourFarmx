package com.example.yourfarm.Service;

import com.example.yourfarm.API.ApiException;
import com.example.yourfarm.Model.Farm;
import com.example.yourfarm.Model.OrderFarmer;
import com.example.yourfarm.Model.OrderGuidance;
import com.example.yourfarm.Model.OrderPlant;
import com.example.yourfarm.Repository.FarmRepository;
import com.example.yourfarm.Repository.OrderGuidanceRepository;
import com.example.yourfarm.Repository.OrderPlantRepository;
import com.example.yourfarm.Repository.SpecialistRepository;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderPlantService {

    private final OrderPlantRepository orderPlantRepository;
    private final FarmRepository farmRepository;

    //ADMIN
    public List<OrderPlant> getAllOrderPlant() {
        if (orderPlantRepository.findAll().isEmpty())
            throw new ApiException("EmptyList");
        else return orderPlantRepository.findAll();
    }


    //-------------------------------------   end CRUD  ---------------------------
    //1
    public void updateStatusOrderPlant(Integer farmId, Integer orderId) {
        OrderPlant orderPlant = orderPlantRepository.findOrderPlantById(orderId);

        if (orderPlant == null) {
            throw new ApiException("orderPlan id not found");
        }
        // Farm farm=farmRepository.findFarmById(farmId);
        //@Pattern(regexp ="^(Delivered|Ready to deliver|waiting|accepted|Rejected)$")

        if (orderPlant.getStatus().equalsIgnoreCase("Delivered")) {
            throw new ApiException("orderPlan is already Delivered");
        }
        if (orderPlant.getStatus().equalsIgnoreCase("Rejected")) {
            throw new ApiException("orderPlant is rejected can not changed");
        }

        if (orderPlant.getFarm().getId()!= farmId) {
            throw new ApiException("orderPlant not for you");

        } else if (orderPlant.getStatus().equalsIgnoreCase("accepted")) {
            orderPlant.setStatus("Ready to deliver");
        } else if (orderPlant.getStatus().equalsIgnoreCase("Ready to deliver")) {
            orderPlant.setStatus("Delivered");
        }
        orderPlantRepository.save(orderPlant);
    }
    //reject order 2


    public void rejectOrderPlant(Integer farmId, Integer orderId) {
        OrderPlant orderPlant = orderPlantRepository.findOrderPlantById(orderId);

        if (orderPlant == null) {
            throw new ApiException("orderPlant id not found");
        }

        if (orderPlant.getFarm().getId()!= farmId) {
            throw new ApiException("orderPlant not for you");
        }

        if (orderPlant.getFarm().getId()!= farmId) {
            throw new ApiException("orderPlant not for you");
        }
        orderPlant.setStatus("Rejected");
        orderPlantRepository.save(orderPlant);

    }

  ///3
    public void acceptOrderPlant(Integer farmId, Integer orderId) {
        OrderPlant orderPlant = orderPlantRepository.findOrderPlantById(orderId);

        if (orderPlant == null) {
            throw new ApiException("orderPlant id not found");
        }

        if (orderPlant.getFarm().getId() != farmId)
            throw new ApiException("orderPlant not for you");
        orderPlant.setStatus("accepted");
        orderPlantRepository.save(orderPlant);

    }


}






