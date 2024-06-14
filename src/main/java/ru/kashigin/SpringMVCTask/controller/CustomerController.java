package ru.kashigin.SpringMVCTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kashigin.SpringMVCTask.dto.CustomerDto;
import ru.kashigin.SpringMVCTask.model.Customer;
import ru.kashigin.SpringMVCTask.service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable Long id) {
        return convertToDto(customerService.getCustomerById(id));
    }

    @PostMapping
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = convertToEntity(customerDto);
        return convertToDto(customerService.createCustomer(customer));
    }

    @PutMapping("/{id}")
    public CustomerDto updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        Customer customer = convertToEntity(customerDto);
        return convertToDto(customerService.updateCustomer(id, customer));
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    private CustomerDto convertToDto(Customer customer) {
        CustomerDto Dto = new CustomerDto();
        Dto.setId(customer.getId());
        Dto.setName(customer.getName());
        Dto.setEmail(customer.getEmail());
        return Dto;
    }

    private Customer convertToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        return customer;
    }
}
