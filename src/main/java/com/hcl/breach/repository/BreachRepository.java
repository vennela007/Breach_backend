package com.hcl.breach.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.breach.entity.Breach;

public interface BreachRepository extends JpaRepository<Breach, Integer>{
	

}
