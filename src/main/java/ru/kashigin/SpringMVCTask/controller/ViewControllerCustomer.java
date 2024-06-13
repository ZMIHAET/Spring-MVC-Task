package ru.kashigin.SpringMVCTask.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kashigin.SpringMVCTask.model.Customer;
import ru.kashigin.SpringMVCTask.service.CustomerService;

@Controller
public class ViewControllerCustomer {
    private final CustomerService customerService;

    @Autowired
    public ViewControllerCustomer(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/view/customers")
    public String viewCustomers(Model model){
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }
    @GetMapping("/view/customers/add")
    public String addCustomerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "addCustomer";
    }
    @PostMapping("/view/customers/add")
    public String addCustomerSubmit(@ModelAttribute @Valid Customer customer, BindingResult bindingResult,
                                    Model model){
        if (bindingResult.hasErrors())
            return "addCustomer";
        customerService.createCustomer(customer);
        return "redirect:/view/customers";
    }

    @GetMapping("/view/customers/{id}")
    public String viewCustomer(@PathVariable("id") Long id, Model model){
        Customer customer = customerService.getCustomerById(id);
        if (customer == null)
            throw new RuntimeException("Customer not found");
        model.addAttribute("customer", customer);
        return "customerDetails";
    }

    @GetMapping("/view/customers/edit/{id}")
    public String editCustomerForm(@PathVariable("id") Long id, Model model){
        Customer customer = customerService.getCustomerById(id);
        if (customer == null)
            throw new RuntimeException("Customer not found");
        model.addAttribute("customer", customer);
        return "editCustomer";
    }

    @PostMapping("/view/customers/edit/{id}")
    public String editCustomerSubmit(@PathVariable("id") Long id, @ModelAttribute @Valid Customer customer,
                                     BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "editCustomer";
        Customer existingCustomer = customerService.getCustomerById(id);
        if (customer == null)
            throw new RuntimeException("Customer not found");
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        customerService.updateCustomer(id, existingCustomer);
        return "redirect:/view/customers";
    }

    @PostMapping("/view/customers/{id}")
    public String deleteCustomer(@PathVariable("id") Long id, @RequestParam("_method") String method){
        if("delete".equalsIgnoreCase(method))
            customerService.deleteCustomer(id);
        return "redirect:/view/customers";
    }
}
