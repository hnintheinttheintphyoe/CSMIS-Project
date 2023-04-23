package com.dat.csmis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class PriceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private double datPrice;
	@Column(nullable = false)
	private double empPrice;
	@Column(nullable = false)
	private double total;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getDatPrice() {
		return datPrice;
	}
	public void setDatPrice(double datPrice) {
		this.datPrice = datPrice;
	}
	public double getEmpPrice() {
		return empPrice;
	}
	public void setEmpPrice(double empPrice) {
		this.empPrice = empPrice;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
