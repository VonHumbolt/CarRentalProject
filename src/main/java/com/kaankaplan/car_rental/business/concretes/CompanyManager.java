package com.kaankaplan.car_rental.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kaankaplan.car_rental.business.abstracts.CompanyService;
import com.kaankaplan.car_rental.business.abstracts.OperationClaimService;
import com.kaankaplan.car_rental.dataAccess.CompanyDao;
import com.kaankaplan.car_rental.entity.Company;
import com.kaankaplan.car_rental.entity.OperationClaim;

@Service
public class CompanyManager implements CompanyService{

	private final CompanyDao companyDao;
	private final PasswordEncoder passwordEncoder;
	private final OperationClaimService operationClaimService;

	@Autowired
	public CompanyManager(CompanyDao companyDao, PasswordEncoder passwordEncoder,
			OperationClaimService operationClaimService) {
		super();
		this.companyDao = companyDao;
		this.passwordEncoder = passwordEncoder;
		this.operationClaimService = operationClaimService;
	}

	@Override
	public List<Company> getallCompanies(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		
		return this.companyDao.findAll(pageable).getContent();
	}

	@Override
	public List<Company> findByCityName(String cityName, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1 , pageSize);
		return this.companyDao.findByCityName(cityName, pageable);
	}

	@Override
	public Company getCompanyById(int companyId) {
		
		return this.companyDao.getById(companyId);
	}

	@Override
	public void add(Company company) {
		
		company.setPassword(passwordEncoder.encode(company.getPassword()));
		
		OperationClaim claim = this.operationClaimService.getClaimByClaimName("COMPANY");
		company.setClaim(claim);
		
		this.companyDao.save(company);
		
		
		
	}

	@Override
	public void deleteById(int companyId) {
		
		this.companyDao.deleteById(companyId);
	}
	
	
	
}
