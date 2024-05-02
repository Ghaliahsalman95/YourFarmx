package com.example.yourfarm.Repository;

import com.example.yourfarm.Model.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialistRepository extends JpaRepository<Specialist,Integer> {
    Specialist findSpecialistById(Integer id);

    List<Specialist> findAllByRegion(String district);
}
