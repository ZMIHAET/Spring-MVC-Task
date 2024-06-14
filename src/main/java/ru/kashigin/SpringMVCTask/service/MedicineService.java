package ru.kashigin.SpringMVCTask.service;

import ru.kashigin.SpringMVCTask.model.Medicine;

import java.util.List;

public interface MedicineService {
    List<Medicine> getAllMedicines();

    Medicine getMedicineById(Long id);

    Medicine createMedicine(Medicine medicine);

    Medicine updateMedicine(Long id, Medicine medicine);

    void deleteMedicine(Long id);
}
