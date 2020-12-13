package com.demo.spring.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int eid;
	private String ename;
	private String email;
	
	@OneToMany(targetEntity=AddressEntity.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="eid",referencedColumnName="eid", insertable=true)
	private Set<AddressEntity> addresses;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmployeeEntity(int eid, String ename, String email) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.email = email;
	}
	public EmployeeEntity() {
		super();
		
	}
	public Set<AddressEntity> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<AddressEntity> addresses) {
		this.addresses = addresses;
	}
	
	
	
	
	
	
}
