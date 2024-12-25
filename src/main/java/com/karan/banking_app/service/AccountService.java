package com.karan.banking_app.service;

import com.karan.banking_app.dto.AccountDto;

import java.util.List;

public interface AccountService  {
    AccountDto createAccount(AccountDto account);
    AccountDto getAccountById(Long id);
    AccountDto depositAccount(Long id, double amount);
    AccountDto withdraw(Long id, double amount);
    List<AccountDto> getAllAcounts();
}
