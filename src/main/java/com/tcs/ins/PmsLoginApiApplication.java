package com.tcs.ins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcs.ins.login.messaging.DefaultBatchProcessTriggeredEventProducer;
import com.tcs.ins.login.service.model.LoginModel;

@SpringBootApplication
public class PmsLoginApiApplication implements CommandLineRunner {

	@Autowired
	DefaultBatchProcessTriggeredEventProducer defaultTriggeredEventProducer;

	public static void main(String[] args) {
		SpringApplication.run(PmsLoginApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LoginModel loginModel = new LoginModel();
		loginModel.setEmail("Don");
		loginModel.setLastName("Category-1");
		loginModel.setEmail("abc@gmail.com");
		defaultTriggeredEventProducer.sendMessage(loginModel);
		System.out.println("sending message from producer : " + loginModel);
	}
}
