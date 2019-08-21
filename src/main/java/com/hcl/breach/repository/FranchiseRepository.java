package com.hcl.breach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.breach.entity.Franchise;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {

}
