package com.bruno.projects.mccourse.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.projects.mccourse.domain.Category;
import com.bruno.projects.mccourse.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public Category getCategory(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElse(null); 
	}

}
