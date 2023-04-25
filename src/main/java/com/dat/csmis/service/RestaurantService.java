package com.dat.csmis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dat.csmis.entity.RestaurantEntity;
import com.dat.csmis.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepository repo;
	
	public void save(RestaurantEntity entity) {
		repo.save(entity);
	}
	public int count() {
		return (int) repo.count();
	}
	public void updateA(String active, int id) {
		repo.updateA(active, id);
	}
}
