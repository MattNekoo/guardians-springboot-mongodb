package com.mattnekoo.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mattnekoo.workshopmongo.domain.User;
import com.mattnekoo.workshopmongo.dto.UserListDTO;
import com.mattnekoo.workshopmongo.entities.Filme;
import com.mattnekoo.workshopmongo.entities.ListFilm;
import com.mattnekoo.workshopmongo.repositories.FilmeRepository;
import com.mattnekoo.workshopmongo.repositories.ListFilmRepository;
import com.mattnekoo.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private ListFilmRepository listFilmRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		filmeRepository.deleteAll();
		listFilmRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Lexie Grey", "lexie@gmail.com");
		
		Filme f1 = new Filme(null, "Batman", "Filme do Morcego", 1999);

		userRepository.saveAll(Arrays.asList(maria, u2, u3));
		filmeRepository.save(f1);
		
		ListFilm l1 = new ListFilm(null, "Meus Filmes", new UserListDTO(maria));
				
		listFilmRepository.save(l1);

	}
}
