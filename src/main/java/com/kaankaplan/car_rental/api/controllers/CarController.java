package com.kaankaplan.car_rental.api.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kaankaplan.car_rental.business.abstracts.CarService;
import com.kaankaplan.car_rental.entity.Car;

@Controller
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
	public String findByCarName(@PathVariable String carName, @RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize, Model model) {
		
		List<Car> carList = this.carService.findByCarName(carName, pageNo.orElse(1), pageSize.orElse(10));
		model.addAttribute("carList", carList);
		
		return "carList";
	}
	
	@GetMapping("getSortedByPrice")
	public String getSortedByPrice(@RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize, Model model) {
		
		List<Car> carList = this.carService.getSortedByPrice(pageNo.orElse(1), pageSize.orElse(10));
		
		model.addAttribute("carList", carList);
		
		return "carList";
	}
	
	@GetMapping("getCarsByCarTypeId/{typeId}")
	public String getCarsByCarTypeId(@PathVariable int typeId, @RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize, Model model) {
		
		List<Car> carList = this.carService.getCarsByCarTypeId(typeId, pageNo.orElse(1), pageSize.orElse(10));
		
		model.addAttribute("carList", carList);
		
		return "carList";
	}
	
	@GetMapping("carIsEmpty/{carId}")
	public String carIsEmpty(@PathVariable int carId, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date rentDay, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date returnDay, 
			Model model) {
		
		Car car = this.carService.carIsEmptyBetweenGivenDays(carId, rentDay, returnDay);
		if (car != null) {
			model.addAttribute(car);
			return "rent";
		}
				
		return "redirect:/api/cars/"+carId;
	}
	
	@GetMapping("getCarsByEmptyDay")
	public String getCarsByEmptyDay(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date rentDay, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date returnDay, @RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize,
			Model model) {
		
		List<Car> carList = this.carService.getCarsByEmptyDay(rentDay, returnDay, pageNo.orElse(1), pageSize.orElse(10));
		model.addAttribute("carList", carList);
		
		return "carList";
	}
	
	@GetMapping("getCarsByCompanyId/{companyId}")
	public String getCarsByCompanyId(@PathVariable int companyId, @RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize, Model model) {
		
		List<Car> carList = this.carService.getCarsByCompanyId(companyId, pageNo.orElse(1), pageSize.orElse(10));
		
		model.addAttribute("carList", carList);
		
		return "carList";
	}
	
	@GetMapping("getall")
	public String getallCars(@RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize, Model model) {
		
		List<Car> carList = this.carService.getallCars(pageNo.orElse(1), pageSize.orElse(10));
		model.addAttribute("carList", carList);
		
		return "carList";
	}
	
	@GetMapping("/{carId}")
	public String getCarById(@PathVariable int carId, Model model) {
		
		Car car = this.carService.getCarById(carId);
		
		model.addAttribute("car", car);
		
		return "carDetail";
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
