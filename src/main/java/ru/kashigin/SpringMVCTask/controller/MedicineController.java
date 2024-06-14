package ru.kashigin.SpringMVCTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kashigin.SpringMVCTask.dto.MedicineDto;
import ru.kashigin.SpringMVCTask.model.Medicine;

import org.springframework.web.bind.annotation.*;
import ru.kashigin.SpringMVCTask.service.MedicineService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {
    private final MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping
    public List<MedicineDto> getAllMedicines() {
        return medicineService.getAllMedicines().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MedicineDto getMedicineById(@PathVariable Long id) {
        return convertToDto(medicineService.getMedicineById(id));
    }

    @PostMapping
    public MedicineDto createMedicine(@RequestBody MedicineDto medicineDto) {
        Medicine medicine = convertToEntity(medicineDto);
        return convertToDto(medicineService.createMedicine(medicine));
    }

    @PutMapping("/{id}")
    public MedicineDto updateMedicine(@PathVariable Long id, @RequestBody MedicineDto medicineDto) {
        Medicine medicine = convertToEntity(medicineDto);
        return convertToDto(medicineService.updateMedicine(id, medicine));
    }

    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
    }

    private MedicineDto convertToDto(Medicine medicine) {
        MedicineDto Dto = new MedicineDto();
        Dto.setId(medicine.getId());
        Dto.setName(medicine.getName());
        Dto.setPrice(medicine.getPrice());
        Dto.setStock(medicine.getStock());
        return Dto;
    }

    private Medicine convertToEntity(MedicineDto medicineDto) {
        Medicine medicine = new Medicine();
        medicine.setId(medicineDto.getId());
        medicine.setName(medicineDto.getName());
        medicine.setPrice(medicineDto.getPrice());
        medicine.setStock(medicineDto.getStock());
        return medicine;
    }
}
