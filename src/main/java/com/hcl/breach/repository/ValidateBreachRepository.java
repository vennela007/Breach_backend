/**
 * 
 */
package com.hcl.breach.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.breach.entity.Breach;

/**
 * @author Gurpreet Singh
 *
 */
@Repository
public interface ValidateBreachRepository extends JpaRepository<Breach, Integer> {
	
	public Optional<Breach> findByStatus(String status);

}
