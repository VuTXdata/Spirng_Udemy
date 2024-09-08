package com.vuhocspringboot.AOPDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AopDaoImpl implements AopDao{
    @Override
    public boolean addAccount() {
        System.out.println("Running: (" + getClass() + "): Add Account Database.");
        return true;
    }
}
