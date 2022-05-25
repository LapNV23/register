package com.example.registerlogin.model;

import com.example.registerlogin.entity.Account;
import jdk.internal.dynalink.linker.LinkerServices;

import java.util.List;

public interface AccountModel {
    Account save(Account obj);//save data
    List<Account> findAll();
    Account findById(int id);
    Account findByUsername(String username);
    Account findByEmail(String email);
    Account update(int id, Account updateObj);
    boolean delete(int id);
}
