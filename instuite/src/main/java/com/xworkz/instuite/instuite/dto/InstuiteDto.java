package com.xworkz.instuite.instuite.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class InstuiteDto implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;
	private String Type;
	private boolean isActive = true;
	public InstuiteDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InstuiteDto(int id, String name, String location, String type, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		Type = type;
		this.isActive = isActive;
	}
	
	
	@Override
	public String toString() {
		return "InstuiteDto [id=" + id + ", name=" + name + ", location=" + location + ", Type=" + Type + ", isActive="
				+ isActive + "]";
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
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	

}
