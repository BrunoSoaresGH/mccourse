package com.bruno.projects.mccourse;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bruno.projects.mccourse.domain.Category;
import com.bruno.projects.mccourse.repositories.CategoryRepository;

@SpringBootApplication
public class MccourseApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(MccourseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
	}

}
