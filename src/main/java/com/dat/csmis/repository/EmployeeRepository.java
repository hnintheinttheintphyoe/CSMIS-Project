package com.dat.csmis.repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.dat.csmis.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	@Query("select e from EmployeeEntity e where e.staffId=?1")
	  Optional<EmployeeEntity> findByStaffId(String staffId);
	  
	  @Modifying
	  @Transactional
	  @Query("update EmployeeEntity e set e.staffId= ?1, e.doorLog= ?2, e.email= ?3, e.name= ?4, "
	      + "e.password= ?5, e.team= ?6, e.role= ?7, e.dept= ?8, e.division= ?9, e.status= ?10 "
	      + "where e.id= ?11")
	    void update(String staffId,String doorLog, String email,
	          String name,String password,String team,String role,
	          String dept,String division,String status, long id);
}
