package ru.kashigin.SpringMVCTask.service.impls;

import org.springframework.stereotype.Service;
import ru.kashigin.SpringMVCTask.model.Medicine;
import ru.kashigin.SpringMVCTask.repository.MedicineRepository;
import ru.kashigin.SpringMVCTask.repository.PharmacyRepository;
import ru.kashigin.SpringMVCTask.service.MedicineService;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {
    private final MedicineRepository repository;
    public MedicineServiceImpl(MedicineRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Medicine> getAllMedicines() {
        return repository.findAll();
    }

    @Override
    public Medicine getMedicineById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Medicine createMedicine(Medicine medicine) {
        return repository.save(medicine);
    }

    @Override
    public Medicine updateMedicine(Long id, Medicine medicine) {
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
            return repository.save(medicine);
        }
        return null;
    }

    @Override
    public void deleteMedicine(Long id) {
        repository.deleteById(id);
    }
}
