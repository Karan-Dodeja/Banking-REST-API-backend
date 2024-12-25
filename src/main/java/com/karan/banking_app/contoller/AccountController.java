package com.karan.banking_app.contoller;

import com.karan.banking_app.dto.AccountDto;
import com.karan.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountServicel;

    public AccountController(AccountService accountServicel) {
        this.accountServicel = accountServicel;
    }

    @PostMapping()
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountServicel.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountServicel.getAccountById(id);
        return  ResponseEntity.ok(accountDto);
    }

    // PUT: localhost:8080/api/accounts/{id}/deposit
    // in body: {amount:"5000"}
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request)
    {
        Double amount = request.get("amount");
        AccountDto account = accountServicel.depositAccount(id, amount);
        return ResponseEntity.ok(account);
    }

}