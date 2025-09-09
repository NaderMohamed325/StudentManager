package com.nader.studentmanager.controller;

import com.nader.studentmanager.entity.School;
import com.nader.studentmanager.service.SchoolService;
import com.nader.studentmanager.service.dto.AddSchoolDto;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public School findSchoolById(@PathVariable Long id) {
        return schoolService.getSchoolById(id);
    }
}
