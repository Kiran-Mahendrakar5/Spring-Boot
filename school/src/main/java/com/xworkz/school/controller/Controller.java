package com.xworkz.school.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.school.dto.SchoolDto;
import com.xworkz.school.service.SchoolService;

@RestController

public class Controller {
	@Autowired
	SchoolService service;

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/save")
	public String save(@RequestBody SchoolDto dto) {
		boolean save = service.save(dto);
		if (save) {
			return "Saving";
		}
		return "notsaving";

	}

	@GetMapping("/read")
	public Iterable<SchoolDto> read() {
		Iterable<SchoolDto> read = service.read();
		return read;

	}

	@GetMapping("/findId/{id}")
	public Optional<SchoolDto> findId(@PathVariable int id) {
		Optional<SchoolDto> fi = service.findById(id);
		return fi;

	}

	@GetMapping("/findName/{name}")
	public List<SchoolDto> findName(@PathVariable String name) {
		List<SchoolDto> fn = service.findByName(name);
		return fn;
	}

	@PutMapping("/update/{id}")
	public String update(@RequestParam String name, @PathVariable int id) {
		
		int update =  service.updateNameById(name, id);
		if(update==1) {
			return "updated succefully";
		}
		return "not updated";
	}
	@GetMapping("/findPage/{pageNumber}/{pageSize}")
	public Page<SchoolDto> findPage(@PathVariable Integer pageNumber,@PathVariable Integer pageSize){
		return service.findAllByPage(pageNumber, pageSize, null);
	}
	@GetMapping("/findPage/{pageNumber}/{pageSize}/{sortProperties}")
	public Page<SchoolDto> findPage(@PathVariable Integer pageNumber,@PathVariable Integer pageSize,@PathVariable String sortProperties){
		return service.findAllByPage(pageNumber, pageSize, sortProperties);
		
	}
	
	

}
