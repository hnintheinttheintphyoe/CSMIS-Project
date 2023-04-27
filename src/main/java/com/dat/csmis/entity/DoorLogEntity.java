package com.dat.csmis.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DoorLogEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String StaffId;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String date;
	@Column(nullable = false)
	private String doorLog;
	@Column(nullable = false)
	private String dept;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStaffId() {
		return StaffId;
	}
	public void setStaffId(String staffId) {
		StaffId = staffId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDoorLog() {
		return doorLog;
	}
	public void setDoorLog(String doorLog) {
		this.doorLog = doorLog;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
	
	
	
	

}
