package com.nader.studentmanager.controller;

import com.nader.studentmanager.entity.School;
import com.nader.studentmanager.service.SchoolService;
import com.nader.studentmanager.service.dto.AddSchoolDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    public SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public School addSchool(@RequestBody AddSchoolDto school) {
        return schoolService.addSchool(school);
    }
}
