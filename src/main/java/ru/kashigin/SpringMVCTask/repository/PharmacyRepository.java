package ru.kashigin.SpringMVCTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kashigin.SpringMVCTask.model.Pharmacy;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
}
