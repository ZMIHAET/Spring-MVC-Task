package ru.kashigin.SpringMVCTask.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PharmacyDTO {
    //объявление полей
    private Long id;
    private String name;
    private String address;
}
