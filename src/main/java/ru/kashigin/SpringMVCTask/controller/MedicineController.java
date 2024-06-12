package ru.kashigin.SpringMVCTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kashigin.SpringMVCTask.dto.MedicineDTO;
import ru.kashigin.SpringMVCTask.dto.PharmacyDTO;
import ru.kashigin.SpringMVCTask.model.Medicine;
import ru.kashigin.SpringMVCTask.model.Pharmacy;

import org.springframework.web.bind.annotation.*;
import ru.kashigin.SpringMVCTask.service.MedicineService;
import ru.kashigin.SpringMVCTask.service.PharmacyService;

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
    public List<MedicineDTO> getAllMedicines(){
        return medicineService.getAllMedicines().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MedicineDTO getMedicineById(@PathVariable Long id){
        return convertToDTO(medicineService.getMedicineById(id));
    }

    @PostMapping
    public MedicineDTO createMedicine(@RequestBody MedicineDTO medicineDTO){
        Medicine medicine = convertToEntity(medicineDTO);
        return convertToDTO(medicineService.createMedicine(medicine));
    }

    @PutMapping("/{id}")
    public MedicineDTO updateMedicine(@PathVariable Long id, @RequestBody MedicineDTO medicineDTO){
        Medicine medicine = convertToEntity(medicineDTO);
        return convertToDTO(medicineService.updateMedicine(id, medicine));
    }

    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable Long id){
        medicineService.deleteMedicine(id);
    }

    private MedicineDTO convertToDTO(Medicine medicine){
        MedicineDTO dto = new MedicineDTO();
        dto.setId(medicine.getId());
        dto.setName(medicine.getName());
        dto.setPrice(medicine.getPrice());
        dto.setStock(medicine.getStock());
        return dto;
    }

    private Medicine convertToEntity(MedicineDTO medicineDTO){
        Medicine medicine = new Medicine();
        medicine.setId(medicineDTO.getId());
        medicine.setName(medicineDTO.getName());
        medicine.setPrice(medicineDTO.getPrice());
        medicine.setStock(medicineDTO.getStock());
        return medicine;
    }
}