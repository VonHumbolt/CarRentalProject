package com.kaankaplan.car_rental.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "carss")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private int carId;
	
	@Column(name = "car_name")
	private String carName;

	@Column(name = "price")
	private double dailyPrice;
	
	@Column(name = "price_start_day")
	private Date priceStartDay;
	
	@Column(name = "price_expiration_day")
	private Date priceExpirationDay;
	
	@Column(name = "model_year")
	private int modelYear;
	
	@Column(name = "fuel")
	private String fuel;
	
	@Column(name = "gear")
	private String gear;
	
	@Column(name = "motor_power")
	private int motorPower;
	
	@Column(name = "color")
	private String color;
	
	@ManyToOne
	@JoinColumn(name = "car_type")
	private CarType carType;
	
	@ManyToOne
	@JoinColumn(name = "rented_day")
	private CarRentDay carRentDay;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
}
