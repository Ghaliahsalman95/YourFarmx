package com.example.yourfarm.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlantsDTO {

    private int id;
    @Positive
    @NotNull(message ="Quantity must not be empty" )

    private Integer Quantity=0;
}
