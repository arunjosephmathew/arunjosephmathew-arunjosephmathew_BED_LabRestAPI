package com.greatlearning.debateRegistration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.debateRegistration.entity.Role;
import com.greatlearning.debateRegistration.entity.User;
import com.greatlearning.debateRegistration.repository.UserRepository;

@SpringBootApplication
public class DebateRegistrationWebApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DebateRegistrationWebApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		BCryptPasswordEncoder bCryptPassEncoder = new BCryptPasswordEncoder();

		Role adminRole = new Role();
		adminRole.setRoleName("ADMIN");

		Role userRole = new Role();
		userRole.setRoleName("USER");

		User adminUser = new User();
		adminUser.setUsername("Admin");
		adminUser.setPassword(bCryptPassEncoder.encode("admin"));
		adminUser.setRoles(new ArrayList<Role>(Arrays.asList(adminRole, userRole)));

		User user = new User();
		user.setUsername("User");
		user.setPassword(bCryptPassEncoder.encode("user"));
		user.setRoles(new ArrayList<Role>(Arrays.asList(userRole)));

		ExampleMatcher matcher = ExampleMatcher.matchingAny().withMatcher("username",
				ExampleMatcher.GenericPropertyMatchers.exact());

		List<User> adminUsers = userRepository.findAll(Example.of(adminUser, matcher));
		List<User> users = userRepository.findAll(Example.of(user, matcher));
		System.out.println("Admins present in database = " + adminUsers.size());
		System.out.println("Users present in database = " + adminUsers.size());

		if (adminUsers.size() == 0 && users.size() == 0)
			userRepository.saveAll(new ArrayList<>(Arrays.asList(adminUser, user)));
		else {
			if (adminUsers.size() == 0)
				userRepository.save(adminUser);
			if (users.size() == 0)
				userRepository.save(user);
		}
	}

}
