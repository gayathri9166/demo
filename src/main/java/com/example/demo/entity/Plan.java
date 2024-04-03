package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long planid;
	private Long planprice;
	private String plandetails;
	private String planname;
	public Long getPlanid() {
		return planid;
	}
	public void setPlanid(Long planid) {
		this.planid = planid;
	}
	public Long getPlanprice() {
		return planprice;
	}
	public void setPlanprice(Long planprice) {
		this.planprice = planprice;
	}
	public String getPlandetails() {
		return plandetails;
	}
	public void setPlandetails(String plandetails) {
		this.plandetails = plandetails;
	}
	public String getPlanname() {
		return planname;
	}
	public void setPlanname(String planname) {
		this.planname = planname;
	}
	
	

}
