package com.kaankaplan.car_rental.dataAccess;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kaankaplan.car_rental.entity.CarRentDay;

@Repository
public interface CarRentDayDao extends JpaRepository<CarRentDay, Integer>{

//	@Query("From CarRentDay c where c.rentDay = :rentDay and c.returnDay = returnDay")
//	List<CarRentDay> getCarRentDaysByRentAndReturnDay(Date rentDay, Date returnDay);
}
