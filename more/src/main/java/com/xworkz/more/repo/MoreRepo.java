package com.xworkz.more.repo;

import com.xworkz.more.dto.MoreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoreRepo extends JpaRepository<MoreDto, Integer> {

}
