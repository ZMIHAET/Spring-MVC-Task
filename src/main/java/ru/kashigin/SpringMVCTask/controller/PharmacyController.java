package ru.kashigin.SpringMVCTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kashigin.SpringMVCTask.dto.PharmacyDto;
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
    public List<PharmacyDto> getAllPharmacies() {
        return pharmacyService.getAllPharmacies().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PharmacyDto getPharmacyById(@PathVariable Long id) {
        return convertToDto(pharmacyService.getPharmacyById(id));
    }

    @PostMapping
    public PharmacyDto createPharmacy(@RequestBody PharmacyDto pharmacyDto) {
        Pharmacy pharmacy = convertToEntity(pharmacyDto);
        return convertToDto(pharmacyService.createPharmacy(pharmacy));
    }

    @PutMapping("/{id}")
    public PharmacyDto updatePharmacy(@PathVariable Long id, @RequestBody PharmacyDto pharmacyDto) {
        Pharmacy pharmacy = convertToEntity(pharmacyDto);
        return convertToDto(pharmacyService.updatePharmacy(id, pharmacy));
    }

    @DeleteMapping("/{id}")
    public void deletePharmacy(@PathVariable Long id) {
        pharmacyService.deletePharmacy(id);
    }

    private PharmacyDto convertToDto(Pharmacy pharmacy) {
        PharmacyDto Dto = new PharmacyDto();
        Dto.setId(pharmacy.getId());
        Dto.setName(pharmacy.getName());
        Dto.setAddress(pharmacy.getAddress());
        return Dto;
    }

    private Pharmacy convertToEntity(PharmacyDto pharmacyDto) {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setId(pharmacyDto.getId());
        pharmacy.setName(pharmacyDto.getName());
        pharmacy.setAddress(pharmacyDto.getAddress());
        return pharmacy;
    }
}
