package ru.kashigin.SpringMVCTask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kashigin.SpringMVCTask.model.Customer;
import ru.kashigin.SpringMVCTask.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
            return repository.save(customer);
        }
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
