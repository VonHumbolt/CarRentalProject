package com.kaankaplan.car_rental.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaankaplan.car_rental.business.abstracts.OperationClaimService;
import com.kaankaplan.car_rental.dataAccess.OperationClaimDao;
import com.kaankaplan.car_rental.entity.OperationClaim;

@Service
public class OperationClaimManager implements OperationClaimService {

	private final OperationClaimDao operationClaimDao;

	@Autowired
	public OperationClaimManager(OperationClaimDao operationClaimDao) {
		super();
		this.operationClaimDao = operationClaimDao;
	}

	@Override
	public List<OperationClaim> getallClaims() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperationClaim getClaimByClaimName(String claimName) {
		
		return this.operationClaimDao.findByClaimName(claimName);
	}

	@Override
	public void add(OperationClaim operationClaim) {
		
		this.operationClaimDao.save(operationClaim);
		
	}

	@Override
	public void deleteById(int claimId) {
		
		this.operationClaimDao.deleteById(claimId);
		
	}
	
	
}
