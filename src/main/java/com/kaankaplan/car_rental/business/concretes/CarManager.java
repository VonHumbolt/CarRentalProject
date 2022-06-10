package com.kaankaplan.car_rental.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kaankaplan.car_rental.business.abstracts.CarService;
import com.kaankaplan.car_rental.dataAccess.CarDao;
import com.kaankaplan.car_rental.entity.Car;

@Service
public class CarManager implements CarService {

	private final CarDao carDao;
	
	@Autowired
	public CarManager(CarDao carDao) {
		super();
		this.carDao = carDao;
	}

	@Override
	public List<Car> findByCarName(String carName, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1 , pageSize);
		return this.carDao.findByCarName(carName, pageable);
	}

	@Override
	public List<Car> getSortedByPrice(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1 , pageSize);
		return this.carDao.getSortedByPrice(pageable);
	}

	@Override
	public List<Car> getCarsByCarTypeId(int typeId, int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo -1 , pageSize);
		
		return this.carDao.getCarsByCarTypeId(typeId, pageable);
	}

	@Override
	public List<Car> getCarsByEmptyDay(Date rentDay, Date returnDay, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1 , pageSize);
		return this.carDao.getCarsByEmptyDay(rentDay, returnDay, pageable);
	}

	@Override
	public List<Car> getCarsByCompanyId(int companyId, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1 , pageSize);
		return this.carDao.getCarsByCompanyId(companyId, pageable);
	}

	@Override
	public List<Car> getallCars(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1 , pageSize);
		return this.carDao.findAll(pageable).getContent();
	}

	@Override
	public Car carIsEmptyBetweenGivenDays(int carId, Date rentDay, Date returnDay) {
		
		return this.carDao.carIsEmptyBetweenGivenDays(carId, rentDay, returnDay);
	}

	@Override
	public void add(Car car) {
		
		this.carDao.save(car);
		
	}

	@Override
	public void deleteById(int carId) {
		
		this.carDao.deleteById(carId);
		
	}

	@Override
	public Car getCarById(int carId) {
		
		return this.carDao.getById(carId);
	}


	
}
