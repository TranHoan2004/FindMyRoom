package com.FindMyRoom;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
//@RestController
@EnableJpaRepositories(basePackages = "com.FindMyRoom.repository")
public class DemoApplication {


//test
//	@GetMapping("/")
//	public String home() {
//		return "index";
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
