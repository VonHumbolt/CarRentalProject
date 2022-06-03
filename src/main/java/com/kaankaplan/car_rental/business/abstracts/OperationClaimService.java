package com.kaankaplan.car_rental.business.abstracts;

import java.util.List;

import com.kaankaplan.car_rental.entity.OperationClaim;

public interface OperationClaimService {

	List<OperationClaim> getallClaims();
		
	OperationClaim getClaimByClaimName(String claimName);
	
	void add(OperationClaim operationClaim);
	
	void deleteById(int claimId);
}
