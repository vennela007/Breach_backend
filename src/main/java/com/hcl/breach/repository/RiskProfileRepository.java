package com.hcl.breach.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.breach.entity.RiskProfile;

public interface RiskProfileRepository extends JpaRepository<RiskProfile, Integer> {

	public Optional<RiskProfile> findByFranchiseAndBusinessAreaAndBreachCategory(String franchise, String businessArea,
			String breachCategory);

//	@Query("select r from RiskProfile r where r.franchise=:franchise and r.businessArea=:businessArea and r.breachCategory=:breachCategory")
//	public Optional<RiskProfile> findByFranchiseAndBusinessAreaAndBreachCategory(@Param("franchise") String franchise,
//			@Param("businessArea") String businessArea, @Param("breachCategory") String breachCategory);

}
