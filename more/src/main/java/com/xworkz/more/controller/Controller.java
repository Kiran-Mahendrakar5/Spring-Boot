package com.xworkz.more.controller;

import com.xworkz.more.dto.MoreDto;
import com.xworkz.more.service.MoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    MoreService service;

    @PostMapping("/save")
    public String save(@RequestBody MoreDto dto) {
        boolean save = service.save(dto);
        if (save) {
            return "Saving";
        }
        return "notsaving";

    }

}
