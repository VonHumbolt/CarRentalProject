package com.kaankaplan.car_rental.business.abstracts;

import java.util.Date;

public interface CarRentDayService {
	
	void add(int carId, Date rentDay, Date returnDay);
	
	void deleteByCarId(int carId);
}
