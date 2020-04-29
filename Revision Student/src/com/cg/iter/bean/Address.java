package com.cg.iter.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address_table")
public class Address {
	@Id
    private int houseNo;
    private String houseName;
    private String city;
	public Address() {
		System.out.println("addr constr");
	}
	public Address(int houseNo, String houseName, String city) {
		super();
		this.houseNo = houseNo;
		this.houseName = houseName;
		this.city = city;
	}
	public Address(String houseName, String city) {
		super();
		this.houseName = houseName;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", houseName=" + houseName + ", city=" + city + "]";
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
    
}
