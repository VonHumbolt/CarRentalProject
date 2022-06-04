package com.kaankaplan.car_rental.dataAccess;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kaankaplan.car_rental.entity.Car;

@Repository
public interface CarDao extends JpaRepository<Car, Integer>{

	List<Car> findByCarName(String carName, Pageable pageable);
	
	@Query("From Car c order by c.dailyPrice asc")
	List<Car> getSortedByPrice(Pageable pageable);
	
	@Query("From Car c where c.carType.typeId = :typeId")
	List<Car> getCarsByCarTypeId(int typeId, Pageable pageable);

	@Query("From Car c where c.carRentDay.rentDay < :rentDay and c.carRentDay.returnDay > :returnDay")
	List<Car> getCarsByEmptyDay(Date rentDay, Date returnDay, Pageable pageable);
	
	@Query("From Car c where c.company.userId = :companyId")
	List<Car> getCarsByCompanyId(int companyId, Pageable pageable);
}
