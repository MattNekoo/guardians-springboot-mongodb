package com.mattnekoo.workshopmongo.config;

import java.util.Arrays;

import com.mattnekoo.workshopmongo.entities.*;
import com.mattnekoo.workshopmongo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mattnekoo.workshopmongo.domain.User;
import com.mattnekoo.workshopmongo.dto.UserListDTO;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	@Autowired
	private AnimeRepository animeRepository;

	@Autowired
	private ListFilmRepository listFilmRepository;
	
	@Autowired
	private ListAnimeRepository listAnimeRepository;

	@Autowired
	private PendenciaAnimeRepository pendenciaAnimeRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		filmeRepository.deleteAll();
		listFilmRepository.deleteAll();
		animeRepository.deleteAll();
		listAnimeRepository.deleteAll();
		pendenciaAnimeRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User lexie = new User(null, "Lexie Grey", "lexie@gmail.com");
		
		Filme f1 = new Filme(null, "Batman", "Filme do Morcego", 1999);
		Filme f2 = new Filme(null, "Dunkirk", "Filme de Guerra", 2017);
		Filme f3 = new Filme(null, "Interestellar", "Filme do Tempo", 2015);
		
		Anime a1 = new Anime(null, "Gin no Saji", "TV", 2014, 11, 8.1, 9, 1);
		Anime a2 = new Anime(null, "Ajin 1", "TV", 2014, 11, 8.1, 9, 1);
		Anime a3 = new Anime(null, "Ajin 2", "TV", 2014, 11, 8.1, 9, 2);

		userRepository.saveAll(Arrays.asList(maria, alex, lexie));
		filmeRepository.saveAll(Arrays.asList(f1,f2,f3));
		animeRepository.saveAll(Arrays.asList(a1,a2,a3));
		
		ListFilm l1 = new ListFilm(null, "Meus Filmes", new UserListDTO(maria));
		ListFilm l2 = new ListFilm(null, "Filmes Marvel", new UserListDTO(alex));
		
		ListAnime al1 = new ListAnime(null, "Gin no Saji");
		ListAnime al2 = new ListAnime(null, "Ajin");
				
		listFilmRepository.saveAll(Arrays.asList(l1,l2));
		
		maria.getLista().addAll(Arrays.asList(l1,l2));
		l1.getFilmes().addAll(Arrays.asList(f1,f3));
		
		al1.getAnimes().addAll(Arrays.asList(a1));
		al2.getAnimes().addAll(Arrays.asList(a2,a3));
		
		userRepository.save(maria);
		listFilmRepository.save(l1);
		listAnimeRepository.saveAll(Arrays.asList(al1,al2));

		PendenciaAnime p1 = new PendenciaAnime(null, "Another OVA",2013);

		pendenciaAnimeRepository.save(p1);

		a1.getPendencias().addAll(Arrays.asList(p1));

		animeRepository.save(a1);
	}
}
