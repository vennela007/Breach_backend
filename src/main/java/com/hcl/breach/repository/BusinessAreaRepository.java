package com.hcl.breach.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.breach.entity.BusinessArea;

@Repository
public interface BusinessAreaRepository extends JpaRepository<BusinessArea, Integer> {

	List<BusinessArea>  findByFranchiseFranchiseId(Integer franchiseId);

}
