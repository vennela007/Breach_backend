package com.hcl.breach.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.breach.entity.Breach;

@Repository
public interface BreachRepository extends JpaRepository<Breach, Integer> {
	
	List<Breach> findByRoleIdAndStatus(Integer roleId,String status);
	List<Breach> findByStatus(String status);
	public List<Breach> findByRoleId(Integer roleId);

}
