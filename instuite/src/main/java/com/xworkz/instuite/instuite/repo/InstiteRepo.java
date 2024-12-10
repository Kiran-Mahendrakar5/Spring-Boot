package com.xworkz.instuite.instuite.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xworkz.instuite.instuite.dto.InstuiteDto;

@Repository
public interface InstiteRepo extends JpaRepository<InstuiteDto, Integer> {

//	@Modifying
	@Transactional
	@Query("SELECT dto FROM InstuiteDto dto WHERE dto.name = :name")
	public List<InstuiteDto> findByName(@Param("name") String name);

	@Modifying
	@Transactional
	@Query("UPDATE InstuiteDto dto SET dto.name = :name WHERE dto.id = :id")
	int updateNameById(@Param("name") String name, @Param("id") int id);
	


//	@Modifying
//	@Transactional
//	@Query("update InstuiteDto dto set dto.name = :name where dto.id = :id")
//	public int updateNameById(@Param("name") String name, @Param("id") int id);

//	@Modifying
//	@Transactional
//	@Query("DELETE FROM InstuiteDto dto WHERE dto.id = :id AND dto.name = :name")
//	int deleteByNameAndId(@Param("name") String name, @Param("id") int id);

	@Modifying
	@Transactional
	@Query("DELETE FROM InstuiteDto dto WHERE dto.id = :id AND (:name IS NULL OR dto.name = :name)")
	int deleteByNameAndId(@Param("name") String name, @Param("id") int id);

//	List<InstuiteDto> findAll();

	@Query("SELECT dto FROM InstuiteDto dto WHERE dto.isActive = true")
	List<InstuiteDto> findAll();

}
