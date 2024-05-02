package com.example.yourfarm.Repository;

import com.example.yourfarm.Model.OrderFarmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderFarmerRepository extends JpaRepository<OrderFarmer,Integer> {
    List<OrderFarmer> findOrderFarmerByFarmerId(Integer farmerId);
    List<OrderFarmer> findOrderFarmerByCompanyId(Integer companyId);
    List<OrderFarmer> findOrderFarmerByCustomerId(Integer customerId );
    OrderFarmer findOrderFarmerById(Integer id);

}
