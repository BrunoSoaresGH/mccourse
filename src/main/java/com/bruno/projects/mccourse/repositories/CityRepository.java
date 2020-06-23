package com.bruno.projects.mccourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.projects.mccourse.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{}
