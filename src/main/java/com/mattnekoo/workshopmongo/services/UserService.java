package com.mattnekoo.workshopmongo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mattnekoo.workshopmongo.domain.User;
import com.mattnekoo.workshopmongo.dto.UserDTO;
import com.mattnekoo.workshopmongo.repositories.UserRepository;
import com.mattnekoo.workshopmongo.services.exception.DatabaseException;
import com.mattnekoo.workshopmongo.services.exception.ObjectNotFoundException;
import com.mattnekoo.workshopmongo.services.exception.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}
	
	/* DELETE USER */
	public void delete(String id) {
		try {
			repository.deleteById(id);			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	/* UPDATE USER */
	public User update(User obj) {
		try {
			Optional<User> newObj = repository.findById(obj.getId());
			User user = newObj.get();
			updateData(user, obj);
			return repository.save(user);			
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	}

	// AUXILIAR METHOD FOR USER UPDATE
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(),objDto.getEmail());
	}
}
