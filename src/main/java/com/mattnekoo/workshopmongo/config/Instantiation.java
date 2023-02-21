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
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User lexie = new User(null, "Lexie Grey", "lexie@gmail.com");
		
		Filme f1 = new Filme(null, "Batman", "Filme do Morcego", 1999);
		Filme f2 = new Filme(null, "Dunkirk", "Filme de Guerra", 2017);
		Filme f3 = new Filme(null, "Interestellar", "Filme do Tempo", 2015);

		userRepository.saveAll(Arrays.asList(maria, alex, lexie));
		filmeRepository.saveAll(Arrays.asList(f1,f2,f3));
		
		ListFilm l1 = new ListFilm(null, "Meus Filmes", new UserListDTO(maria));
		ListFilm l2 = new ListFilm(null, "Filmes Marvel", new UserListDTO(maria));
				
		listFilmRepository.saveAll(Arrays.asList(l1,l2));
		
		maria.getLista().addAll(Arrays.asList(l1,l2));
		l1.getFilmes().addAll(Arrays.asList(f1,f3));
		
		userRepository.save(maria);
		listFilmRepository.save(l1);
	}
}
