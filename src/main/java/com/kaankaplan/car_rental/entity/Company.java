package com.kaankaplan.car_rental.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "companies")
public class Company extends User {

	@NotBlank
	@NotNull
	@Column(name = "company_name")
	private String companyName;

	@NotBlank
	@NotNull
	@Column(name = "city_name")
	private String cityName;
	
	@OneToMany(mappedBy = "company")
	private List<Car> cars;
}
