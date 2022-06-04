package com.kaankaplan.car_rental.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaankaplan.car_rental.business.abstracts.CarTypeService;
import com.kaankaplan.car_rental.dataAccess.CarTypeDao;
import com.kaankaplan.car_rental.entity.CarType;

@Service
public class CarTypeManager implements CarTypeService {

	private final CarTypeDao carTypeDao;
	
	@Autowired
	public CarTypeManager(CarTypeDao carTypeDao) {
		super();
		this.carTypeDao = carTypeDao;
	}

	@Override
	public List<CarType> getallCarTypes() {
		
		return this.carTypeDao.findAll();
	}

	
}
