package com.example.spring_homework.Homework1.service;

import com.example.spring_homework.Homework1.domain.Account;
import com.example.spring_homework.Homework1.domain.Currency;
import com.example.spring_homework.Homework1.domain.Customer;
import com.example.spring_homework.Homework1.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    Customer save(Customer obj);
    boolean delete(Customer obj);
    void deleteAll(List<Customer> entities);
    void saveAll(List<Customer> entities);
    List<Customer> findAll();
    boolean deleteById(Long id);
    Customer getOne(long id);
    void createAccountForCustomer(Long id, Currency currency, Double amount);
    void deleteAccountFromCustomer(Long customerId, String accountNumber);
    Customer update(Long id, Customer updatedCustomer);
    void assignAccountsToCustomers();
}
