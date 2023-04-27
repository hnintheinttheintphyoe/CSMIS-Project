package com.dat.csmis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dat.csmis.entity.EmployeeEntity;
import com.dat.csmis.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repo;
	
	Optional<EmployeeEntity> selectOne(long id){
		return repo.findById(id);
	}
}
