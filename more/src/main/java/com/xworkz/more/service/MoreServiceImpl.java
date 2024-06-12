package com.xworkz.more.service;

import com.xworkz.more.dto.MoreDto;
import com.xworkz.more.repo.MoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoreServiceImpl implements MoreService{
    @Autowired
    MoreRepo repo;
    @Override
    public boolean save(MoreDto dto) {
        if(dto!=null) {
            repo.save(dto);
            return true;
        }
        return false;
    }


}
