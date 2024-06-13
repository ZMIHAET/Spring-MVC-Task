package ru.kashigin.SpringMVCTask.service;

import org.springframework.stereotype.Service;
import ru.kashigin.SpringMVCTask.dto.PharmacyDTO;
import ru.kashigin.SpringMVCTask.model.Pharmacy;
import ru.kashigin.SpringMVCTask.repository.PharmacyRepository;

import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService{
    private final PharmacyRepository repository;

    public PharmacyServiceImpl(PharmacyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pharmacy> getAllPharmacies(){
        return repository.findAll();
    }

    @Override
    public Pharmacy getPharmacyById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Pharmacy createPharmacy(Pharmacy pharmacy) {
        return repository.save(pharmacy);
    }

    @Override
    public Pharmacy updatePharmacy(Long id, Pharmacy pharmacy) {
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
            return repository.save(pharmacy);
        }
        return null;
    }

    @Override
    public void deletePharmacy(Long id) {
        repository.deleteById(id);
    }
}
