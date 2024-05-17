package com.example.spring_homework.Homework1.dao;

import com.example.spring_homework.Homework1.domain.Account;
import com.example.spring_homework.Homework1.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDao implements Dao<Customer> {
    private static Long customerIdCounter = 1L;
    private List<Customer> customers = new ArrayList<>();

    public CustomerDao() {
        initializeDefaultCustomers();
    }

    private void initializeDefaultCustomers() {
        for (Customer customer : DefaultCustomers.createCustomers()) {
            save(customer);
        }
    }

    @Override
    public Customer save(Customer customer) {
        customer.setId(customerIdCounter++);
        customers.add(customer);
        return customer;
    }

    @Override
    public boolean delete(Customer customer) {
        return customers.remove(customer);
    }

    @Override
    public void deleteAll(List<Customer> entities) {
        entities.clear();
    }

    @Override
    public void saveAll(List<Customer> entities) {
        for (Customer customer: entities){
            save(customer);
        }
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public boolean deleteById(long id) {
        for (Customer customer: customers){
            if (customer.getId() == id){
                customers.remove(customer);
                return true;
            }
        }
        return false;
    }

    @Override
    public Customer getOne(long id) {
        for (Customer customer: customers){
            if (customer.getId() == id){
                return customer;
            }
        }
        return null;
    }


    public Customer update(Customer updatedCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getId().equals(updatedCustomer.getId())) {
                customers.set(i, updatedCustomer);
                return customer;
            }
        }
        throw new RuntimeException("Customer not found with id: " + updatedCustomer.getId());
    }
}
