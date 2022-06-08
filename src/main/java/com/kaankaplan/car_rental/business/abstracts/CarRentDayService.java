package com.kaankaplan.car_rental.business.abstracts;

import java.util.Date;
import java.util.List;

import com.kaankaplan.car_rental.entity.CarRentDay;

public interface CarRentDayService {
	
//	List<CarRentDay> getCarRentDaysByRentAndReturnDay(Date rentDay, Date returnDay);
	
	void add(int carId, Date rentDay, Date returnDay);
	
	void deleteById(int rentId);
}
