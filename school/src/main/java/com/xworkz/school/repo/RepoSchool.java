package com.xworkz.school.repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xworkz.school.dto.SchoolDto;

@Repository
public interface RepoSchool extends JpaRepository<SchoolDto, Integer>,PagingAndSortingRepository<SchoolDto, Integer> {

	@Modifying
	@Transactional
	@Query("SELECT dto FROM SchoolDto dto WHERE dto.name = :name")
	public List<SchoolDto> findByName(@Param("name") String name);
	
	@Modifying
	@Transactional
	@Query("update SchoolDto dto set dto.name = :name where dto.id = :id")
	public int updateNameById(@Param("name") String name, @Param("id") int id);
	
}
