package com.bruno.projects.mccourse.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.projects.mccourse.domain.Client;
import com.bruno.projects.mccourse.services.ClientService;

@RestController
@RequestMapping(value="/clients")
public class ClientResource {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getClient(@PathVariable Integer id) {
		Client obj = clientService.getClient(id);
		return ResponseEntity.ok().body(obj);
	}

}
