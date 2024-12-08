package com.xworkz.instuite.instuite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
