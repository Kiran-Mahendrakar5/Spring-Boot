package com.xworkz.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.school.dto.SchoolDto;
import com.xworkz.school.repo.RepoSchool;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	RepoSchool repo;

	@Override
	public boolean save(SchoolDto dto) {
		if (dto != null) {
			repo.save(dto);
			return true;
		}
		return false;
	}

	@Override
	public Iterable<SchoolDto> read() {
		Iterable<SchoolDto> read = repo.findAll();
		return read;
	}

	@Override
	public Optional<SchoolDto> findById(int id) {
		if (id != 0) {
			Optional<SchoolDto> read = repo.findById(id);
			return read;
		}
		return null;
	}

	@Override
	public List<SchoolDto> findByName(String name) {
		if (name != null) {
			 List<SchoolDto> fname =  repo.findByName(name);
			return fname;
		}
		return null;
	}

	@Override
	public int updateNameById(String name, int id) {
	
			return 	repo.updateNameById(name, id);
			
	
	}

}
