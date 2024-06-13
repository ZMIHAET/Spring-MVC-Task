package ru.kashigin.SpringMVCTask.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kashigin.SpringMVCTask.model.Medicine;
import ru.kashigin.SpringMVCTask.service.MedicineService;

@Controller
public class ViewControllerMedicine {
    private final MedicineService medicineService;

    @Autowired
    public ViewControllerMedicine(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/view/medicines")
    public String viewMedicines(Model model){
        model.addAttribute("medicines", medicineService.getAllMedicines());
        return "medicines";
    }

    @GetMapping("/view/medicines/add")
    public String addMedicineForm(Model model){
        model.addAttribute("medicine", new Medicine());
        return "addMedicine";
    }

    @PostMapping("/view/medicines/add")
    public String addMedicineSubmit(@ModelAttribute @Valid Medicine medicine, BindingResult bindingResult,
                                    Model model){
        if (bindingResult.hasErrors())
            return "addMedicine";
        medicineService.createMedicine(medicine);
        return "redirect:/view/medicines";
    }

    @GetMapping("/view/medicines/{id}")
    public String viewMedicine(@PathVariable("id") Long id, Model model){
        Medicine medicine = medicineService.getMedicineById(id);
        if (medicine == null)
            throw new RuntimeException("Medicine not found");
        model.addAttribute("medicine", medicine);
        return "medicineDetails";
    }

    @GetMapping("/view/medicines/edit/{id}")
    public String editMedicineForm(@PathVariable("id") Long id, Model model){
        Medicine medicine = medicineService.getMedicineById(id);
        if (medicine == null)
            throw new RuntimeException("Medicine not found");
        model.addAttribute("medicine", medicine);
        return "editMedicine";
    }

    @PostMapping ("/view/medicines/edit/{id}")
    public String editMedicineSubmit(@PathVariable("id") Long id,
                                     @ModelAttribute @Valid Medicine medicine,
                                     BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "editMedicine";
        Medicine existingMedicine = medicineService.getMedicineById(id);
        if (medicine == null)
            throw new RuntimeException("Medicine not found");
        existingMedicine.setName(medicine.getName());
        existingMedicine.setPrice(medicine.getPrice());
        existingMedicine.setStock(medicine.getStock());
        medicineService.updateMedicine(id, existingMedicine);
        return "redirect:/view/medicines";
    }

    @PostMapping("/view/medicines/{id}")
    public String deleteMedicine(@PathVariable("id") Long id, @RequestParam("_method") String method){
        if("delete".equalsIgnoreCase(method))
            medicineService.deleteMedicine(id);
        return "redirect:/view/medicines";
    }
}
