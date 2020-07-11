package com.bruno.projects.mccourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.projects.mccourse.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{}
