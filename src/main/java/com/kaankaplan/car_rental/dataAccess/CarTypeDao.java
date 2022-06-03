package com.kaankaplan.car_rental.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaankaplan.car_rental.entity.CarType;

@Repository
public interface CarTypeDao extends JpaRepository<CarType, Integer>{

	
}
