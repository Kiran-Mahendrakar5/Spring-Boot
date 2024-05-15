package com.xworkz.school.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SchoolDto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;
	private String brand;
	private int age;

	public SchoolDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SchoolDto(int id, String name, String location, String brand, int age) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.brand = brand;
		this.age = age;
	}

	@Override
	public String toString() {
		return "SchoolDto [id=" + id + ", name=" + name + ", location=" + location + ", brand=" + brand + ", age=" + age
				+ "]";
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
