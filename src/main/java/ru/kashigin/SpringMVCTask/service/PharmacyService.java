package ru.kashigin.SpringMVCTask.service;

import org.springframework.stereotype.Service;
import ru.kashigin.SpringMVCTask.model.Pharmacy;

import java.util.List;

public interface PharmacyService {
    List<Pharmacy> getAllPharmacies();
    Pharmacy getPharmacyById(Long id);
    Pharmacy createPharmacy(Pharmacy pharmacy);
    Pharmacy updatePharmacy(Long id, Pharmacy pharmacy);
    void deletePharmacy(Long id);
}