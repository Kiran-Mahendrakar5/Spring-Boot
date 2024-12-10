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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.instuite.instuite.dto.InstuiteDto;
import com.xworkz.instuite.instuite.service.ServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

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
		System.out.println("Fetched Data: " + read); // Log the data to check what is returned
		return read;
	}

//	@GetMapping("/reads")
//	public Iterable<InstuiteDto> reads() {
//		Iterable<InstuiteDto> readingshow = service.reads(); // This will call the service, which uses repo.findAll()
//		System.out.println("Fetched Data: " + readingshow);
//		return readingshow;
//	}
	@GetMapping("/reads")
	public ResponseEntity<?> reads() {
	    Iterable<InstuiteDto> readingshow = service.reads(); // Fetch active records from service

	    // Check if there are any active records
	    if (((List<InstuiteDto>) readingshow).size() > 0) {
	        System.out.println("Fetched Active Data: " + readingshow);
	        return ResponseEntity.ok(readingshow); // Return the active records
	    } else {
	        System.out.println("No active records found.");
	        return ResponseEntity.status(404).body("No active records found."); // Return a not found message if no active records
	    }
	}



	@GetMapping("/findName/{name}")
	public List<InstuiteDto> findName(@PathVariable String name) {
		List<InstuiteDto> fn = service.findByName(name);
		return fn;
	}

//	@PutMapping("/update/{id}")
//	public String update(@PathVariable int id, @RequestParam String name) {
//		System.out.println("Updating ID: " + id + " with Name: " + name);
//
//		int update = service.updateNameById(name, id);
//		if (update > 0) {
//			return "Updated successfully";
//		}
//		return "Not updated";
//	}
	
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


//Internal Flow for a Request
//Client Request → Controller
//The client sends a request, and the controller handles it.
//Controller → Service
//The controller delegates the logic to the service.
//Service → Repository
//If database interaction is needed, the service calls the repository.
//Repository → Database
//The repository interacts with the database and retrieves data.
//Database → Repository → Service → DTO
//The retrieved data is passed back through the repository and service layers, often converted to a DTO.
//Service → Controller → Response
//The final data is returned to the controller, which sends it back as an HTTP response.
//Illustration of Internal Flow
//plaintext
//Copy code
//Client Request (React App)
//        ↓
//[Controller] → Handles HTTP Request
//        ↓
//[Service] → Executes Business Logic
//        ↓
//[Repository] → Interacts with the Database
//        ↓
//[Database] → Returns Data to Repository
//        ↑
//[Repository → Service → DTO]
//        ↑
//[Controller]
//        ↑
//Client Response (React App)

