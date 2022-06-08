package com.kaankaplan.car_rental.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaankaplan.car_rental.business.abstracts.CarRentDayService;
import com.kaankaplan.car_rental.dataAccess.CarRentDayDao;
import com.kaankaplan.car_rental.entity.CarRentDay;

@Service
public class CarRentDayManager implements CarRentDayService {

	private final CarRentDayDao carRentDayDao;

	@Autowired
	public CarRentDayManager(CarRentDayDao carRentDayDao) {
		super();
		this.carRentDayDao = carRentDayDao;
	}
	
//	@Override
//	public List<CarRentDay> getCarRentDaysByRentAndReturnDay(Date rentDay, Date returnDay) {
//		
//		return this.carRentDayDao.getCarRentDaysByRentAndReturnDay(rentDay, returnDay);
//	}

	@Override
	public void add(int carId, Date rentDay, Date returnDay) {
		
		// Doldur
		
	}

	@Override
	public void deleteById(int rentId) {
		
		this.carRentDayDao.deleteById(rentId);
		
	}
	
	
	
}
