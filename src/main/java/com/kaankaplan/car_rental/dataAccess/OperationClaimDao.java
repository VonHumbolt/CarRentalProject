package com.kaankaplan.car_rental.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaankaplan.car_rental.entity.OperationClaim;

@Repository
public interface OperationClaimDao extends JpaRepository<OperationClaim, Integer>{

	OperationClaim findByClaimName(String claimName);
}
