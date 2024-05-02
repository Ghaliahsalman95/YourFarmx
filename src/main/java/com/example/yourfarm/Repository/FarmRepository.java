package com.example.yourfarm.Repository;

import com.example.yourfarm.Model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmRepository extends JpaRepository<Farm,Integer> {
    Farm findFarmById(Integer id);
    Farm findFarmByName(String name);
    List<Farm> findAllByRegion(String district);
}
