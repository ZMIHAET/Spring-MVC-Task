package ru.kashigin.SpringMVCTask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PharmacyDto {
    //объявление полей
    private Long id;
    private String name;
    private String address;
}
