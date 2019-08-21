package com.hcl.breach.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.breach.entity.RiskProfile;

public interface RiskProfileRepository extends JpaRepository<RiskProfile, Integer> {

	public Optional<RiskProfile> findByFranchiseAndBusinessAreaAndBreachCategory(String franchise, String businessArea,
			String breachCategory);


}
