
package ru.kashigin.SpringMVCTask.repository;

import org.springframework.stereotype.Repository;
import ru.kashigin.SpringMVCTask.model.Pharmacy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryPharmacyRepository {
    private final List<Pharmacy> pharmacies = new ArrayList<>();

    public List<Pharmacy> findAll(){
        return new ArrayList<>(pharmacies);
    }

    public Optional<Pharmacy> findById(Long id){
        return pharmacies.stream().filter(pharmacy -> pharmacy.getId().equals(id)).findFirst();
    }

    public Pharmacy save(Pharmacy pharmacy){
        pharmacies.add(pharmacy);
        return pharmacy;
    }

    public void deleteById(Long id){
        pharmacies.removeIf(pharmacy -> pharmacy.getId().equals(id));
    }
}
