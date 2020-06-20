package com.bruno.projects.mccourse.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.projects.mccourse.domain.Category;
import com.bruno.projects.mccourse.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getCategory(@PathVariable Integer id) {
		Category obj = categoryService.getCategory(id);
		return ResponseEntity.ok().body(obj);
	}

}
