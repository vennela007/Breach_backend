package com.hcl.breach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.breach.entity.Breach;


@Repository
public interface BreachRepository extends JpaRepository<Breach, Integer>{
	

	
}
