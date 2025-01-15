package com.xworkz.instuite.instuite.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.xworkz.instuite.instuite.dto.InstuiteDto;
import com.xworkz.instuite.instuite.repo.InstiteRepo;
import com.xworkz.instuite.utility.Validation;

@Service
public class ServiceImpl implements InstuiteService {

//	@Autowired
//	InstiteRepo repo;
	
	@Autowired
    private InstiteRepo repo;

//	@Override
//	public boolean save(InstuiteDto dto) {
//	if(dto!=null) {
//		repo.save(dto);
//		return true;
//	}
//		return false;
//	}
	@Override
//	public boolean save(InstuiteDto dto) {
//		if (dto != null) {
//			dto.setActive(true);
//			repo.save(dto);
//			System.out.println("save");
//			return true;
//		}
//		return false;
//	}
	public boolean save(InstuiteDto dto) {
	    if (dto == null) {
	        throw new IllegalArgumentException("DTO cannot be null");
	    }
	    // Save logic
	    return true;
	}


	@Override
	public Iterable<InstuiteDto> read() {
		Iterable<InstuiteDto> read = repo.findAll();
		System.out.println(read);
		return read;
	}

	@Override
	public List<InstuiteDto> findByName(String name) {
		if (name != null) {
			List<InstuiteDto> fname = repo.findByName(name);
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

//	@Override
//	public String saveExcelData(MultipartFile file) {
//	    if (file == null || file.isEmpty()) {
//	        throw new RuntimeException("File is empty or not provided");
//	    }
//
//	    try (InputStream is = file.getInputStream(); Workbook workbook = new XSSFWorkbook(is)) {
//	        Sheet sheet = workbook.getSheetAt(0);  
//	        List<InstuiteDto> records = new ArrayList<>();
//
//	        for (Row row : sheet) {
//	            if (row.getRowNum() == 0) continue;  
//
//	            InstuiteDto record = new InstuiteDto();
//
//	           
//	            String name = getCellValue(row, 1);
//	            String location = getCellValue(row, 2);
//	            String type = getCellValue(row, 3);
//
//	            
//	            if (name.isEmpty() || location.isEmpty() || type.isEmpty()) {
//	                continue;  
//	            }
//
//	            
//	            record.setName(name);
//	            record.setLocation(location);
//	            record.setType(type);
//	            record.setActive(true);  
//
//	            records.add(record);
//	        }
//
//	        // Save valid records to the database
//	        if (!records.isEmpty()) {
//	            repo.saveAll(records);
//	            return "Excel data uploaded and saved to the database successfully!";
//	        } else {
//	            return "No valid data found in the Excel file!";
//	        }
//
//	    } catch (Exception e) {
//	        throw new RuntimeException("Failed to parse and save Excel data: " + e.getMessage(), e);
//	    }
//	}
//
//	private String getCellValue(Row row, int cellIndex) {
//	    if (row.getCell(cellIndex) != null) {
//	        return row.getCell(cellIndex).getStringCellValue().trim();
//	    }
//	    return "";  // Return empty string if the cell is null or empty
//	}


	@Override
	public String saveExcelData(MultipartFile file) {
	    if (file == null || file.isEmpty()) {
	        throw new RuntimeException("File is empty or not provided");
	    }

	    // Call Validation class static methods
	    List<String> validLocations = Validation.getValidLocations();
	    List<String> validTypes = Validation.getValidTypes();

	    try (InputStream is = file.getInputStream(); Workbook workbook = new XSSFWorkbook(is)) {
	        Sheet sheet = workbook.getSheetAt(0);
	        List<InstuiteDto> records = new ArrayList<>();

	        for (Row row : sheet) {
	            if (row.getRowNum() == 0)
	                continue;

	            InstuiteDto record = new InstuiteDto();

	            String name = getCellValue(row, 1);
	            String location = getCellValue(row, 2);
	            String type = getCellValue(row, 3);

	            if (name.length() <= 4) {
	                continue;
	            }

	            if (!validLocations.contains(location) || !validTypes.contains(type)) {
	                continue;
	            }

	            record.setName(name);
	            record.setLocation(location);
	            record.setType(type);
	            record.setActive(true);

	            records.add(record);
	        }

	        // Save valid records to the database
	        if (!records.isEmpty()) {
	            repo.saveAll(records);
	            return "Excel data uploaded and saved to the database successfully!";
	        } else {
	            return "No valid data found in the Excel file!";
	        }

	    } catch (Exception e) {
	        throw new RuntimeException("Failed to parse and save Excel data: " + e.getMessage(), e);
	    }
	}

	private String getCellValue(Row row, int cellIndex) {
	    if (row.getCell(cellIndex) != null) {
	        return row.getCell(cellIndex).getStringCellValue().trim();
	    }
	    return ""; // Return empty string if the cell is null or empty
	}

	

//	@Override
//	public Optional<InstuiteDto> findByNameAndLocationAndType(String name, String location, String type) {
//		if(name!=null) {
//			repo.findByNameAndLocationAndType(name, location, type);
//		}
//		return null;
//	}
}
