package ru.kashigin.SpringMVCTask.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.kashigin.SpringMVCTask.model.Pharmacy;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
}
