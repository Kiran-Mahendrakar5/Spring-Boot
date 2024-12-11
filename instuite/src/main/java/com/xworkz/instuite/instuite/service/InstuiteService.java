package com.xworkz.instuite.instuite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.xworkz.instuite.instuite.dto.InstuiteDto;

public interface InstuiteService {
	
	public boolean save(InstuiteDto dto);
	
	public Iterable<InstuiteDto> read();
	
	public Optional<InstuiteDto> findById(int id);
	
	public List<InstuiteDto> findByName(String name);
	
	public int updateNameById(String name ,int id);
	
	public int deleteNameById(String name ,int id);
	
	public Iterable<InstuiteDto> reads() ;
	
	public String saveExcelData(MultipartFile file);

}
