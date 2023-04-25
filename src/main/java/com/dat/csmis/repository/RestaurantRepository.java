package com.dat.csmis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dat.csmis.entity.RestaurantEntity;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Integer> {

	
	@Query("update RestaurantEntity r set r.status= ?1 where r.id= ?2")
	@Modifying
	void updateA(String active, int id);
}
