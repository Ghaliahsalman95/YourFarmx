package com.example.yourfarm.DTO;

import com.example.yourfarm.Model.Plant;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
public class PlantDTO {

    List<PlantsDTO> plantsDTOS;

    @Pattern(regexp = "YYYY/MM/DD")
    private LocalDate receivedDate;

    @Pattern(regexp = "HH-MM-SS")
    private LocalTime TimeOfReceive;

}
