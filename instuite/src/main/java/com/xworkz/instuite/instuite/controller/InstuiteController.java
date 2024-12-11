package com.xworkz.instuite.instuite.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.instuite.instuite.dto.InstuiteDto;
import com.xworkz.instuite.instuite.service.ServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
//@RequestMapping("/api")

public class InstuiteController {

	@Autowired
	ServiceImpl service;

	public InstuiteController() {
		super();
		
	}
	

	
	@PostMapping("/uploadExcel")
//	@RequestMapping(value = "/uploadExcel", method = {RequestMethod.GET, RequestMethod.POST})

	public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) {
	    try {
	        String message = service.saveExcelData(file);
	        return ResponseEntity.ok(message);
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(500).body("Error: " + e.getMessage());
	    }
	}




	@PostMapping("/save")
//	@RequestMapping(value = "/getOtp", method = RequestMethod.GET)
	public String save(@RequestBody InstuiteDto dto) {
		boolean save = service.save(dto);
		if (save) {
			return "Saving";
		}
		return "notsaving";

	}

	@GetMapping("/read")
	public Iterable<InstuiteDto> read() {
		Iterable<InstuiteDto> read = service.read();
		System.out.println("Fetched Data: " + read);
		return read;
	}

	@GetMapping("/reads")
	public ResponseEntity<?> reads() {
		Iterable<InstuiteDto> readingshow = service.reads();

		if (((List<InstuiteDto>) readingshow).size() > 0) {
			System.out.println("Fetched Active Data: " + readingshow);
			return ResponseEntity.ok(readingshow);
		} else {
			System.out.println("No active records found.");
			return ResponseEntity.status(404).body("No active records found.");
		}
	}

	@GetMapping("/findName/{name}")
	public List<InstuiteDto> findName(@PathVariable String name) {
		List<InstuiteDto> fn = service.findByName(name);
		return fn;
	}

	@PutMapping("/update/{id}")
	public String update(@PathVariable int id, @RequestParam String name) {
		System.out.println("Updating record with ID: " + id + " and Name: " + name);

		int update = service.updateNameById(name, id);

		if (update > 0) {
			System.out.println("Update successful");
			return "Updated successfully";
		} else {
			System.out.println("Update failed: ID not found or no changes made.");
			return "Not updated";
		}
	}

	@DeleteMapping("/deleteNameById/{id}")
	public String deleteNameById(@RequestParam(required = false) String name, @PathVariable int id) {
		int result = service.deleteNameById(name, id);
		if (result > 0) {
			return "Deleted successfully";
		}
		return "Deletion failed no matching record found";
	}

}
