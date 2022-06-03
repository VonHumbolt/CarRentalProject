package com.kaankaplan.car_rental.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car_rent_days")
public class CarRentDay {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rent_id")
	private int rentId;
	
	@Column(name  ="rent_day")
	private Date rentDay;
	
	@Column(name ="return_day")
	private Date returnDay;
	
	@OneToMany(mappedBy = "carType")
	@JsonIgnore
	private List<Car> cars;
	
}
