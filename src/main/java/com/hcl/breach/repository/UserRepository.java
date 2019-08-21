package com.hcl.breach.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.breach.entity.Login;

@Repository
public interface UserRepository extends JpaRepository<Login, Integer>{

	public Optional<Login> findByUserNameAndPassword(String userName, String password );
}
