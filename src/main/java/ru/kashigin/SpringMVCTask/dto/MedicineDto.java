package ru.kashigin.SpringMVCTask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDto {
    private Long id;
    private String name;
    private double price;
    private int stock;
}
