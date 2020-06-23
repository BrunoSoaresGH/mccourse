package com.bruno.projects.mccourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.projects.mccourse.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{}
