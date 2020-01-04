package com.yr.entry;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties( value={"hibernateLazyInitializer","handler"})
public class Emp  implements Serializable{
	
	private Integer id;
	private String name;
	private String sex;
	private int age;
	private Dept dept;
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

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", dept=" + dept + "]";
	}
	public Emp (String name) {
		super();
		this.name = name;
	}
	
	
	public Emp() {
		
		
		
	}
	
	
	
	
	

}
