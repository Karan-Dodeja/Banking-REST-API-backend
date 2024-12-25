package com.karan.banking_app.service;

import com.karan.banking_app.dto.AccountDto;
import com.karan.banking_app.entity.Account;
import com.karan.banking_app.mapper.AccountMapper;
import com.karan.banking_app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AccountServiceImpl implements AccountService {


    private AccountRepository accountRepositoryl;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepositoryl) {
        this.accountRepositoryl = accountRepositoryl;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account1 = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepositoryl.save(account1);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepositoryl.findById(id).orElseThrow(() -> new RuntimeException("Account Not Found!"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto depositAccount(Long id, double amount) {
        Account account = accountRepositoryl.findById(id).orElseThrow(() -> new RuntimeException("Account Not Found!"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account account1 = accountRepositoryl.save(account);
        return AccountMapper.mapToAccountDto(account1);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepositoryl.findById(id).orElseThrow(() -> new RuntimeException("Account Not Found!"));

        if(account.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance!");
        }

        double total = account.getBalance() - amount;

        account.setBalance(total);

        Account save = accountRepositoryl.save(account);

        return AccountMapper.mapToAccountDto(save);
    }

}