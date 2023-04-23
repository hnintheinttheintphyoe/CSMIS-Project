package com.dat.csmis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dat.csmis.entity.DoorLogEntity;

public interface DoorLogRepository extends JpaRepository<DoorLogEntity,Long> {

}
