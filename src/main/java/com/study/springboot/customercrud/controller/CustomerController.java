package com.study.springboot.customercrud.controller;


import com.study.springboot.customercrud.entity.Customer;
import com.study.springboot.customercrud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> findAllCustomer() {
        return customerService.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer = customerService.findById(customerId);
        if(customer == null) {
            throw new RuntimeException("Customer not found for customer id =" + customerId);
        }

        return customer;
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        customerService.save(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        Customer customer = customerService.findById(customerId);
        if(customer ==  null) {
            throw new RuntimeException("Customer not found for customer id= " + customerId);
        }

        customerService.deleteById(customerId);

        return "Customer deleted = " + customerId;
    }
}
