package com.kaankaplan.car_rental.business.abstracts;

import java.util.List;

import com.kaankaplan.car_rental.entity.Company;

public interface CompanyService {

	List<Company> getallCompanies(int pageNo, int pageSize);
	
	List<Company> findByCityName(String cityName, int pageNo, int pageSize);
	
	Company getCompanyById(int companyId);
	
	void add(Company company);
	
	void deleteById(int companyId);
}
