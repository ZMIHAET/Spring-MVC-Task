package ru.kashigin.SpringMVCTask.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kashigin.SpringMVCTask.model.Pharmacy;
import ru.kashigin.SpringMVCTask.service.PharmacyService;

@Controller
public class ViewControllerPharmacy {
    private final PharmacyService pharmacyService;

    @Autowired
    public ViewControllerPharmacy(PharmacyService pharmacyService){
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
    public String addPharmacySubmit(@ModelAttribute @Valid Pharmacy pharmacy, BindingResult bindingResult,
                                    Model model) {
        if (bindingResult.hasErrors())
            return "addPharmacy";
        pharmacyService.createPharmacy(pharmacy);
        return "redirect:/view/pharmacies";
    }

    @GetMapping("/view/pharmacies/{id}")
    public String viewPharmacy(@PathVariable("id") Long id, Model model){
        Pharmacy pharmacy = pharmacyService.getPharmacyById(id);
        if (pharmacy == null)
            throw new RuntimeException("Pharmacy not found");
        model.addAttribute("pharmacy", pharmacy);
        return "pharmacyDetails";
    }

    @GetMapping("/view/pharmacies/edit/{id}")
    public String editPharmacyForm(@PathVariable("id") Long id, Model model){
        Pharmacy pharmacy = pharmacyService.getPharmacyById(id);
        if (pharmacy == null)
            throw new RuntimeException("Pharmacy not found");
        model.addAttribute("pharmacy", pharmacy);
        return "editPharmacy";
    }

    @PostMapping("/view/pharmacies/edit/{id}")
    public String editPharmacySubmit(@PathVariable("id") Long id,
                                     @ModelAttribute @Valid Pharmacy pharmacy,
                                     BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "editPharmacy";
        Pharmacy existingPharmacy = pharmacyService.getPharmacyById(id);
        if (existingPharmacy == null)
            throw new RuntimeException("Pharmacy not found");
        existingPharmacy.setName(pharmacy.getName());
        existingPharmacy.setAddress(pharmacy.getAddress());
        pharmacyService.updatePharmacy(id, existingPharmacy);
        return "redirect:/view/pharmacies";
    }

    @PostMapping("/view/pharmacies/{id}")
    public String deletePharmacy(@PathVariable("id") Long id, @RequestParam("_method") String method){
        if("delete".equalsIgnoreCase(method))
            pharmacyService.deletePharmacy(id);
        return "redirect:/view/pharmacies";
    }
}
