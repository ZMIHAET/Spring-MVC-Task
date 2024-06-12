package ru.kashigin.SpringMVCTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kashigin.SpringMVCTask.model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
