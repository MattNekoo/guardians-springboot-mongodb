package com.mattnekoo.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mattnekoo.workshopmongo.domain.User;
import com.mattnekoo.workshopmongo.entities.Filme;
import com.mattnekoo.workshopmongo.repositories.FilmeRepository;
import com.mattnekoo.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FilmeRepository filmeRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		filmeRepository.deleteAll();
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Lexie Grey", "lexie@gmail.com");
		
		Filme f1 = new Filme(null, "Batman", "Filme do Morcego", 1999);

		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		filmeRepository.save(f1);

	}
}
