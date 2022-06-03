package com.kaankaplan.car_rental.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "companies")
public class Company extends User {

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "city_name")
	private String cityName;
	
	@OneToMany(mappedBy = "company")
	private List<Car> cars;
}
