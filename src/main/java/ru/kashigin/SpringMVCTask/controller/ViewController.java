package ru.kashigin.SpringMVCTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kashigin.SpringMVCTask.model.Pharmacy;
import ru.kashigin.SpringMVCTask.service.PharmacyService;

@Controller
public class ViewController {
    private final PharmacyService pharmacyService;

    @Autowired
    public ViewController(PharmacyService pharmacyService){
        this.pharmacyService = pharmacyService;
    }

    @GetMapping("/view/pharmacies")
    public String viewPharmacies(Model model){
        model.addAttribute("pharmacies", pharmacyService.getAllPharmacies());
        return "pharmacies";
    }

    @GetMapping("/view/pharmacies/add")
    public String addPharmacyForm(Model model) {
        model.addAttribute("pharmacy", new Pharmacy());
        return "addPharmacy";
    }

    @PostMapping("/view/pharmacies/add")
    public String addPharmacySubmit(@ModelAttribute Pharmacy pharmacy, Model model) {
        pharmacyService.createPharmacy(pharmacy);
        return "redirect:/view/pharmacies";
    }
}
