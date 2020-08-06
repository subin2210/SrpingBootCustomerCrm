package com.study.springboot.customercrud.dao;

import com.study.springboot.customercrud.entity.Customer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Customer> findAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Customer> customers = session.createQuery("from Customer order by lastName", Customer.class).getResultList();
        return customers;
    }

    @Override
    public Customer findById(int id) {
        Session session = entityManager.unwrap(Session.class);

        Customer customer = session.get(Customer.class,id);

        return  customer;
    }

    @Override
    public void save(Customer customer) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(customer);
    }

    @Override
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Customer customer = session.get(Customer.class,id);
        session.remove(customer);
    }
}
