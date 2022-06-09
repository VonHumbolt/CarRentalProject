package com.kaankaplan.car_rental.business.abstracts;

import java.util.Date;
import java.util.List;

import com.kaankaplan.car_rental.entity.Car;

public interface CarService {

	List<Car> findByCarName(String carName, int pageNo, int pageSize);
	
	List<Car> getSortedByPrice(int pageNo, int pageSize);
		
	List<Car> getCarsByCarTypeId(int typeId, int pageNo, int pageSize);

	List<Car> getCarsByEmptyDay(Date rentDay, Date returnDay, int pageNo, int pageSize);
	
	List<Car> getCarsByCompanyId(int companyId, int pageNo, int pageSize);
	
	List<Car> getallCars(int pageNo, int pageSize);
	
	Car getCarById(int carId);
	
	void add(Car car);
	
	void deleteById(int carId);
}
