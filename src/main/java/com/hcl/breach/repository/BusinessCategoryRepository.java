package com.hcl.breach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.breach.entity.BusinessCategory;
@Repository
public interface BusinessCategoryRepository extends JpaRepository<BusinessCategory, Integer>{

}
