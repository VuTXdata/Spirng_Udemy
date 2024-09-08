package com.vuhocspringboot.AOPDemo.dao;

import com.vuhocspringboot.AOPDemo.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AccountDao {
    void addAccountApp();
    List<Account> findAccount();
}
