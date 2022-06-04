package com.kaankaplan.car_rental.api.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaankaplan.car_rental.business.abstracts.CarService;
import com.kaankaplan.car_rental.entity.Car;

@RestController
@RequestMapping("/api/cars/")
@CrossOrigin
public class CarController {

	private final CarService carService;

	@Autowired
	public CarController(CarService carService) {
		super();
		this.carService = carService;
	}
	
	@GetMapping("getByCarName/{carName}")
	public ResponseEntity<List<Car>> findByCarName(@PathVariable String carName, @RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize) {
		
		List<Car> carList = this.carService.findByCarName(carName, pageNo.orElse(1), pageSize.orElse(10));
		
		return new ResponseEntity<List<Car>>(carList, HttpStatus.OK);
	}
	
	@GetMapping("getSortedByPrice")
	public ResponseEntity<List<Car>> getSortedByPrice(@RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize) {
		
		List<Car> carList = this.carService.getSortedByPrice(pageNo.orElse(1), pageSize.orElse(10));
		
		return new ResponseEntity<List<Car>>(carList, HttpStatus.OK);
	}
	
	@GetMapping("getCarsByCarTypeId/{typeId}")
	public ResponseEntity<List<Car>> getCarsByCarTypeId(@PathVariable int typeId, @RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize) {
		
		List<Car> carList = this.carService.getCarsByCarTypeId(typeId, pageNo.orElse(1), pageSize.orElse(10));
		
		return new ResponseEntity<List<Car>>(carList, HttpStatus.OK);
	}
	
	@GetMapping("getCarsByEmptyDay/{rentDay}/{returnDay}")
	public ResponseEntity<List<Car>> getCarsByEmptyDay(@PathVariable Date rentDay, @PathVariable Date returnDay, @RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize) {
		
		List<Car> carList = this.carService.getCarsByEmptyDay(rentDay, returnDay, pageNo.orElse(1), pageSize.orElse(10));
		
		return new ResponseEntity<List<Car>>(carList, HttpStatus.OK);
	}
	
	@GetMapping("getCarsByCompanyId/{companyId}")
	public ResponseEntity<List<Car>> getCarsByCompanyId(@PathVariable int companyId, @RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize) {
		
		List<Car> carList = this.carService.getCarsByCompanyId(companyId, pageNo.orElse(1), pageSize.orElse(10));
		
		return new ResponseEntity<List<Car>>(carList, HttpStatus.OK);
	}
	
	@GetMapping("getall")
	public ResponseEntity<List<Car>> getallCars(@RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize) {
		
		List<Car> carList = this.carService.getallCars(pageNo.orElse(1), pageSize.orElse(10));
		
		return new ResponseEntity<List<Car>>(carList, HttpStatus.OK);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> add(@RequestBody Car car) {
		
		this.carService.add(car);
		
		return new ResponseEntity<String>("Araba eklendi", HttpStatus.CREATED);
	}
	
	@PostMapping("delete/{carId}")
	public ResponseEntity<String> add(@PathVariable int carId) {
		
		this.carService.deleteById(carId);
		
		return new ResponseEntity<String>("Araba silindi", HttpStatus.OK);
	}
}
