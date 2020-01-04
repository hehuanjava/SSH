package com.yr.entry;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class Dept implements Serializable  {
	
	private Integer id;
	private String name;
	private String manager;
	private  Set<Emp> emp  = new HashSet<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	@JsonIgnore
	public Set<Emp> getEmp() {
		return emp;
	}
	public void setEmp(Set<Emp> emp) {
		this.emp = emp;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", manager=" + manager + "]";
	}
	
	


}
