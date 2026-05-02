package com.minipay;

import com.minipay.dto.UserRequest;
import com.minipay.model.SavingsAccount;
import com.minipay.model.User;
import com.minipay.service.PaymentService;
import com.minipay.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class MinipayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinipayApplication.class, args);
	}

	@Bean
	public CommandLineRunner seedData(UserService userService,
                                      PaymentService paymentService) {
		return args -> {
			// Create users
			UserRequest req1 = new UserRequest();
			req1.setName("Daksh Bhatti");
			req1.setEmail("daksh@minipay.com");
			User u1 = userService.registerUser(req1);

			UserRequest req2 = new UserRequest();
			req2.setName("Priya Sharma");
			req2.setEmail("priya@minipay.com");
			User u2 = userService.registerUser(req2);

			// Create accounts and fund them
			SavingsAccount sa1 = new SavingsAccount(
					2001, u1, "INR", new BigDecimal("500.00"));
			SavingsAccount sa2 = new SavingsAccount(
					2002, u2, "INR", new BigDecimal("500.00"));

			sa1.deposit(new BigDecimal("10000.00"));
			sa2.deposit(new BigDecimal("5000.00"));

			paymentService.addAccount(sa1);
			paymentService.addAccount(sa2);

			System.out.println("Test data seeded successfully");
			System.out.println("Account 2001 balance: " + sa1.getBalance());
			System.out.println("Account 2002 balance: " + sa2.getBalance());
		};
	}
}
