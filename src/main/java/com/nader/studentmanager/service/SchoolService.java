package com.nader.studentmanager.service;

import com.nader.studentmanager.entity.School;
import com.nader.studentmanager.repository.SchoolRepository;
import com.nader.studentmanager.service.dto.AddSchoolDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing School entities.
 * Provides methods to add, retrieve, update, and delete schools.
 * Uses SchoolRepository for database operations.
 * Methods:
 * - addSchool(AddSchoolDto school): Adds a new school.
 * - getSchoolById(Long id): Retrieves a school by its ID.
 * - deleteSchool(Long id): Deletes a school by its ID.
 * - updateSchool(Long id, AddSchoolDto schoolDto): Updates an existing school's details.
 * - getAllSchools(): Retrieves a list of all schools.
 *
 * @Author Nader
 */
@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School addSchool(AddSchoolDto school) {
        School newSchool = new School();
        newSchool.setLocation(school.getLocation());
        newSchool.setName(school.getName());
        return schoolRepository.save(newSchool);
    }

    public School getSchoolById(Long id) {
        return schoolRepository.findById(id).orElse(null);
    }

    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }

    public School updateSchool(Long id, AddSchoolDto schoolDto) {
        return schoolRepository.findById(id).map(school -> {
            school.setName(schoolDto.getName());
            school.setLocation(schoolDto.getLocation());
            return schoolRepository.save(school);
        }).orElse(null);
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }



}
