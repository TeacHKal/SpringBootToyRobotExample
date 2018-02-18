package com.teach.toyrobot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToyrobotApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ToyrobotApplication.class, args);

	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("Application by TeacH");
	}
}
