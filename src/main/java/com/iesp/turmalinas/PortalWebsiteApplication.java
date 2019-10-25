package com.iesp.turmalinas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PortalWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalWebsiteApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("145"));
	}
	
}
