package com.example.SpringSecurity.Spring.Demo.Project;

import com.example.SpringSecurity.Spring.Demo.Project.Model.User;
import com.example.SpringSecurity.Spring.Demo.Project.Repository.UserRepo;
import com.example.SpringSecurity.Spring.Demo.Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringDemoProjectApplication implements CommandLineRunner {
	@Autowired
	UserRepo userRepo;



	public static void main(String[] args) {
		SpringApplication.run(SpringDemoProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User demoUser = User.builder()
				.username("Musaddik")
				.password(new BCryptPasswordEncoder().encode("musa"))
				.authorities("admin")
				.build();
		userRepo.save(demoUser);
	}
}
