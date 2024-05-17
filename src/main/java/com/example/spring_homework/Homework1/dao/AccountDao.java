package com.example.spring_homework.Homework1.dao;

import com.example.spring_homework.Homework1.domain.Account;
import com.example.spring_homework.Homework1.domain.Currency;
import com.example.spring_homework.Homework1.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDao implements Dao<Account> {
    private static Long accountIdCounter = 1L;
    private List<Account> accounts;

    public AccountDao() {
        this.accounts = new ArrayList<>();
        initializeDefaultAccounts();
    }

    private void initializeDefaultAccounts() {
        List<Customer> customers = DefaultCustomers.createCustomers();
        for (Customer customer : customers) {
            Account account = new Account(getCurrencyForCustomer(customer.getName()), customer);
            save(account);
        }
    }

    private static Currency getCurrencyForCustomer(String name) {
        String[] names = DefaultCustomers.names;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                return Currency.values()[i];
            }
        }
        throw new IllegalArgumentException("Unknown customer name: " + name);
    }

    @Override
    public Account save(Account account) {
        account.setId(accountIdCounter++);
        accounts.add(account);
        return account;
    }

    @Override
    public boolean delete(Account account) {
        return accounts.remove(account);
    }

    @Override
    public void deleteAll(List<Account> entities) {
        entities.clear();
    }

    @Override
    public void saveAll(List<Account> entities) {
        for (Account account: entities){
            save(account);
        }

    }

    @Override
    public List<Account> findAll() {
        return accounts;
    }

    @Override
    public boolean deleteById(long id) {
        for (Account account: accounts){
            if (account.getId() == id){
                accounts.remove(account);
                return true;
            }
        }
        return false;
    }

    @Override
    public Account getOne(long id) {
        for (Account account: accounts){
            if (account.getId() == id){
                return account;
            }
        }
        return null;
    }

    public Account findByNumber(String number) {
        for (Account account: accounts){
            if (account.getNumber().equals(number)){
                return account;
            }
        }
        return null;
    }

    public void update(Account account) {
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (acc.getId().equals(account.getId())) {
                accounts.set(i, account);
                return;
            }
        }
        throw new RuntimeException("Customer not found with id: " + account.getId());
    }

}
