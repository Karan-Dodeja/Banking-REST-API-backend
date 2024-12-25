package com.karan.banking_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity
// @Table(name="accounts")
// @Getter
// @Setter
// @AllArgsConstructor
// @NoArgsConstructor
public record Account(Long id, String accountHolderName,double balance) {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    //private String accountHolderName;
    //private double balance;

}