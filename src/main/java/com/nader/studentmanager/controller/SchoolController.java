package com.nader.studentmanager.controller;

import com.nader.studentmanager.entity.School;
import com.nader.studentmanager.service.SchoolService;
import com.nader.studentmanager.service.dto.AddSchoolDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type School controller.
 * Handles HTTP requests related to School entities.
 * Provides endpoints to add, retrieve, update, and delete schools.
 * Uses SchoolService to perform business logic and data operations.
 * Endpoints:
 * - POST /schools: Add a new school.
 * - GET /schools/{id}: Retrieve a school by its ID.
 * - DELETE /schools/{id}: Delete a school by its ID.
 * - PUT /schools/{id}: Update an existing school's details.
 * - GET /schools: Retrieve a list of all schools.
 * - All endpoints are prefixed with /api
 *
 * @Author Nader
 */
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

    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
    }

    @PutMapping("/{id}")
    public School updateSchool(@PathVariable Long id, @RequestBody AddSchoolDto schoolDto) {
        return schoolService.updateSchool(id, schoolDto);
    }

    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

}
