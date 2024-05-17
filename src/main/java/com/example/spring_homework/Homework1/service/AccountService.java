package com.example.spring_homework.Homework1.service;

import com.example.spring_homework.Homework1.domain.Account;

import java.util.List;

public interface AccountService {
    Account save(Account account);
    boolean delete(Account account);
    void deleteAll(List<Account> accounts);
    void saveAll(List<Account> accounts);
    List<Account> findAll();
    boolean deleteById(long id);
    Account getOne(long id);
    Account findByNumber(String number);
    Account depositToAccount(String accountNumber, double amount);
    boolean withdrawFromAccount(String accountNumber, double amount);
    void transferMoney(String fromAccountNumber, String toAccountNumber, double amount);
}
