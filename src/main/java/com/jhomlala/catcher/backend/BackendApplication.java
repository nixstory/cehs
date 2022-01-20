package com.jhomlala.catcher.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reactspring.util.Cipher;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		String encText = Cipher.encrypt("123456", "SHA-256");
		System.out.println(encText.length());
		
		SpringApplication.run(BackendApplication.class, args);
	}

}

