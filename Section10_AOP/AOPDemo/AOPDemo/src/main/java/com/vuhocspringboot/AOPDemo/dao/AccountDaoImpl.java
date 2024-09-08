package com.vuhocspringboot.AOPDemo.dao;

import com.vuhocspringboot.AOPDemo.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Override
    public List<Account> findAccount() {
        Account acc1 = new Account("user1", "123");
        Account acc2 = new Account("user2", "456");
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(acc1);
        accounts.add(acc2);
        return accounts;
    }

    @Override
    public void addAccountApp() {
        System.out.println("Running: (" + getClass() + "): addAccount" );
    }
}
