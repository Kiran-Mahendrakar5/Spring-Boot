package com.xworkz.instuite.instuite.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.instuite.instuite.dto.InstuiteDto;
import com.xworkz.instuite.instuite.service.ServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // Ensure this matches your React app's port
//@RequestMapping("api/")
public class InstuiteController {

	@Autowired
	ServiceImpl service;

	public InstuiteController() {
		super();
		// TODO Auto-generated constructor stub
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

//	@GetMapping("/read")
//	public Iterable<InstuiteDto> read() {
//		Iterable<InstuiteDto> read = service.read();
//		return read;
//
//	}
	@GetMapping("/read")
	public Iterable<InstuiteDto> read() {
	    Iterable<InstuiteDto> read = service.read();
	    System.out.println("Fetched Data: " + read);  // Log the data to check what is returned
	    return read;
	}
	
	@GetMapping("/reads")
	public Iterable<InstuiteDto> reads() {
	    Iterable<InstuiteDto> readingshow =  service.reads();  // This will call the service, which uses repo.findAll()
	    System.out.println("Fetched Data: " +readingshow);
		return readingshow;
	}
	





	@GetMapping("/findName/{name}")
	public List<InstuiteDto> findName(@PathVariable String name) {
		List<InstuiteDto> fn = service.findByName(name);
		return fn;
	}

	@PutMapping("/update/{id}")
	public String update(@RequestParam String name, @PathVariable int id) {

		int update = service.updateNameById(name, id);
		if (update == 1) {
			return "updated succefully";
		}
		return "not updated";
	}

	@DeleteMapping("/deleteNameById/{id}")
	public int deleteNameById(@RequestParam String name, @PathVariable int id) {
		return service.deleteNameById(name, id);
	}
}
