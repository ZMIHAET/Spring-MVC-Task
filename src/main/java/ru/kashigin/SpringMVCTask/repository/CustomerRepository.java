package ru.kashigin.SpringMVCTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kashigin.SpringMVCTask.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
