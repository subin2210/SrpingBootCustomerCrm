package com.study.springboot.customercrud.dao;

import com.study.springboot.customercrud.entity.Customer;

import java.util.List;

public interface CustomerDao {

    public List<Customer> findAll();

    public Customer findById(int id);

    public void save(Customer customer);

    public void deleteById(int id);
}
