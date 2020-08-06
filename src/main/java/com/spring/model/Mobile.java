package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Mobile")
public class Mobile {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String mobileNo;
	
//	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Login.class)
//	@JoinColumn(name = "username", nullable = false)
//	private Login loginDetails;

	public Mobile() {
		
	}
	
	public Mobile(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String toString() {
		return "Mobile no = " + getMobileNo();
	}
}
