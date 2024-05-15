package com.xworkz.school.service;

import java.util.List;
import java.util.Optional;

import com.xworkz.school.dto.SchoolDto;

public interface SchoolService {
	
	public boolean save(SchoolDto dto);
	
	public Iterable<SchoolDto> read();
	
	public Optional<SchoolDto> findById(int id);
	
	public List<SchoolDto> findByName(String name);
	
	public int updateNameById(String name ,int id);
	
	
	
	
}
