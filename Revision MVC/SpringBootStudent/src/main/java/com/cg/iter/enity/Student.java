package com.cg.iter.enity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "stud_hib_mvc")
public class Student {
	@Id
	private int id;
	private String name;
	private long mobile;
	private String subject;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="addr_id")
	private Address address;
	public Student() {
		super();
	}
	public Student(int id, String name, long mobile, String subject, Address address) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.subject = subject;
		this.address = address;
	}
	public Student(int id, String name, long mobile, String subject) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.subject = subject;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
