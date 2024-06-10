package ru.kashigin.SpringMVCTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kashigin.SpringMVCTask.dto.PharmacyDTO;
import ru.kashigin.SpringMVCTask.model.Pharmacy;

import org.springframework.web.bind.annotation.*;
import ru.kashigin.SpringMVCTask.service.PharmacyService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pharmacies")
public class PharmacyController {
    private final PharmacyService pharmacyService;

    @Autowired
    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @GetMapping
    public List<PharmacyDTO> getAllPharmacies(){
        return pharmacyService.getAllPharmacies().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PharmacyDTO getPharmacyById(@PathVariable Long id){
        return convertToDTO(pharmacyService.getPharmacyById(id));
    }

    @PostMapping
    public PharmacyDTO createPharmacy(@RequestBody PharmacyDTO pharmacyDTO){
        Pharmacy pharmacy = convertToEntity(pharmacyDTO);
        return convertToDTO(pharmacyService.createPharmacy(pharmacy));
    }

    @PutMapping("/{id}")
    public PharmacyDTO updatePharmacy(@PathVariable Long id, @RequestBody PharmacyDTO pharmacyDTO){
        Pharmacy pharmacy = convertToEntity(pharmacyDTO);
        return convertToDTO(pharmacyService.updatePharmacy(id, pharmacy));
    }

    @DeleteMapping("/{id}")
    public void deletePharmacy(@PathVariable Long id){
        pharmacyService.deletePharmacy(id);
    }

    private PharmacyDTO convertToDTO(Pharmacy pharmacy){
        PharmacyDTO dto = new PharmacyDTO();
        dto.setId(pharmacy.getId());
        dto.setName(pharmacy.getName());
        dto.setAddress(pharmacy.getAddress());
        return dto;
    }

    private Pharmacy convertToEntity(PharmacyDTO pharmacyDTO){
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setId(pharmacyDTO.getId());
        pharmacy.setName(pharmacyDTO.getName());
        pharmacy.setAddress(pharmacyDTO.getAddress());
        return pharmacy;
    }
}
