package com.kaankaplan.car_rental.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaankaplan.car_rental.entity.Company;

@Repository
public interface CompanyDao extends JpaRepository<Company, Integer>{

	List<Company> findByCityName(String cityName);
	
}
