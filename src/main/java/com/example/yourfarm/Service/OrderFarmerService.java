package com.example.yourfarm.Service;

import com.example.yourfarm.API.ApiException;
import com.example.yourfarm.Model.Farm;
import com.example.yourfarm.Model.OrderFarmer;
import com.example.yourfarm.Repository.FarmRepository;
import com.example.yourfarm.Repository.FarmerRepository;
import com.example.yourfarm.Repository.OrderFarmerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderFarmerService {

    private final OrderFarmerRepository orderFarmerRepository;
    private final FarmerRepository farmerRepository;
    private final FarmRepository farmRepository;


    //ADMIN
    public List<OrderFarmer> getAllOrderFarmer(){
        if (orderFarmerRepository.findAll().isEmpty())
            throw new ApiException("EmptyList");
        else return orderFarmerRepository.findAll();
    }

    //COMPANY - CUSTOMER " يحتاج لها تعديل
//    public void addOrderFarmer( Integer FarmerId , Guidance guidance){
//        Specialist specialist1 = specialistRepository.findSpecialistById(specialistId);
//        guidance.setSpecialist(specialist1);
//        guidanceRepository.save(guidance);
//
//    }

    //-------------------------------------   end CRUD  ---------------------------








//    public List<OrderFarmer> bcurrentOrders(Integer branchId) {
//        Branch branch = branchRepository.findBranchById(branchId);
//        if (branch == null) {
//            throw new ApiException("Branch id not found");
//        }
//
//        List<OrderFarmer> currentOrders = orderFarmerRepository.findOrdersByBranch(branch);
//        if (currentOrders == null) {
//            throw new ApiException("Orders not found");
//        }
//
//        List<OrderFarmer> filteredOrders = new ArrayList<>();
//        for (OrderFarmer orderFarmer : currentOrders) {
//            String status = orderFarmer.getStatus().toLowerCase();
//            if (status.equals("received stuff") || status.equals("received to laundry") || status.equals("accepted")) {
//                filteredOrders.add(orderFarmer);
//            }
//        }
//
//        return filteredOrders;
//    }
//
//    public List<OrderFarmer> bpreviousOrders(Integer branchId) {
//        Branch branch = branchRepository.findBranchById(branchId);
//        if (branch == null) {
//            throw new ApiException("Branch id not found");
//        }
//
//        List<OrderFarmer> previousOrders = orderFarmerRepository.findOrdersByBranch(branch);
//        if (previousOrders == null) {
//            throw new ApiException("Orders not found");
//        }
//
//        List<OrderFarmer> filteredOrders = new ArrayList<>();
//        for (OrderFarmer orderFarmer : previousOrders) {
//            if (orderFarmer.getStatus().equalsIgnoreCase("delivered")) {
//                filteredOrders.add(orderFarmer);
//            }
//        }
//
//        return filteredOrders;
//    }



}
