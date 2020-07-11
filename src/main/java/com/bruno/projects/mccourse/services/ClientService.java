package com.bruno.projects.mccourse.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.projects.mccourse.domain.Client;
import com.bruno.projects.mccourse.repositories.ClientRepository;
import com.bruno.projects.mccourse.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Client getClient(Integer id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Client.class.getName())); 
	}

}
