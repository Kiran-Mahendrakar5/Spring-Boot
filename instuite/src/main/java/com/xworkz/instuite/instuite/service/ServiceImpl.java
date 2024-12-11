package com.xworkz.instuite.instuite.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.result.Row;
import com.xworkz.instuite.instuite.dto.InstuiteDto;
import com.xworkz.instuite.instuite.repo.InstiteRepo;


@Service
public class ServiceImpl implements InstuiteService {

	
	@Autowired
	InstiteRepo repo;
	
	
//	@Override
//	public boolean save(InstuiteDto dto) {
//	if(dto!=null) {
//		repo.save(dto);
//		return true;
//	}
//		return false;
//	}
	@Override
	public boolean save(InstuiteDto dto) {
	    if (dto != null) {
	        dto.setActive(true);  
	        repo.save(dto); 
	        return true;
	    }
	    return false;
	}


	@Override
	public Iterable<InstuiteDto> read() {
		Iterable<InstuiteDto> read = repo.findAll();
		return read;
	}

	@Override
	public List<InstuiteDto> findByName(String name) {
		if (name != null) {
			 List<InstuiteDto> fname =  repo.findByName(name);
			return fname;
		}
		return null;
	}



//	@Override
//	public int updateNameById(String name, int id) {
//	
//			return 	repo.updateNameById(name, id);
//			
//	
//	}
	
	@Override
	public int updateNameById(String name, int id) {
	    System.out.println("Service Layer: Attempting to update ID: " + id + " with Name: " + name);
	    int result = repo.updateNameById(name, id);
	    if (result > 0) {
	        System.out.println("Service Layer: Update successful");
	    } else {
	        System.out.println("Service Layer: Update failed, no matching ID found");
	    }
	    return result;
	}

	
	    

	

	@Override
	public Optional<InstuiteDto> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

//	public int deleteNameById(String name, int id) {
//        return repo.deleteByNameAndId(name, id);
//    }
	
	public int deleteNameById(String name, int id) {
	    Optional<InstuiteDto> dto = repo.findById(id);
	    if (dto.isPresent()) {
	        InstuiteDto entity = dto.get();
	        entity.setActive(false);  
	        repo.save(entity); 
	        return 1; 
	    }
	    return 0; 
	}

	
	@Override
	public Iterable<InstuiteDto> reads() {
	    return repo.findAll();  
	}
	

	
	@Override
	public String saveExcelData(MultipartFile file) {
	    if (file == null || file.isEmpty()) {
	        throw new RuntimeException("File is empty or not provided");
	    }

	    try (InputStream is = file.getInputStream(); Workbook workbook = new XSSFWorkbook(is)) {
	        Sheet sheet = workbook.getSheetAt(0);
	        List<InstuiteDto> records = new ArrayList<>();

	        for (org.apache.poi.ss.usermodel.Row row : sheet) {
	            if (row.getRowNum() == 0) continue; // Skip header row

	            InstuiteDto record = new InstuiteDto();
	            record.setId((int) row.getCell(0).getNumericCellValue());
	            record.setName(row.getCell(1).getStringCellValue());
	            record.setLocation(row.getCell(2).getStringCellValue());
	            record.setType(row.getCell(3).getStringCellValue());
	            record.setActive(true);

	            records.add(record);
	        }

	        repo.saveAll(records);
	        return "Excel data uploaded and saved to the database successfully!";
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to parse and save Excel data: " + e.getMessage(), e);
	    }
	}





}
