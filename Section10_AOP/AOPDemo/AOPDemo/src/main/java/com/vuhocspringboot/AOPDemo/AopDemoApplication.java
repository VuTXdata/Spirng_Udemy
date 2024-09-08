package com.vuhocspringboot.AOPDemo;

import com.vuhocspringboot.AOPDemo.Service.TrafficFortuneService;
import com.vuhocspringboot.AOPDemo.dao.AccountDao;
import com.vuhocspringboot.AOPDemo.dao.AopDao;
import com.vuhocspringboot.AOPDemo.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static java.lang.Thread.sleep;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(AopDao aopDao,
								  AccountDao accountDao,
								  TrafficFortuneService trafficFortuneService) {
		return runner ->{
			// demoTheBeforeAdvise(aopDao, accountDao);
			// demoTheAfterAdvise(accountDao);
			demoTheAroundAdvise(trafficFortuneService);
		};
	}

	private void demoTheAroundAdvise(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main Program: demoTheAroundAdvise");
		System.out.println("Calling getFortune()");
		String data = trafficFortuneService.getFortune();
		System.out.println("My data: " + data);
		System.out.println("Finish!");
	}

	private void demoTheAfterAdvise(AccountDao accountDao) {
		List<Account> ls = accountDao.findAccount();
	}

	private void demoTheBeforeAdvise(AopDao aopDao, AccountDao accountDao) {
		aopDao.addAccount();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		accountDao.addAccountApp();
	}
}

