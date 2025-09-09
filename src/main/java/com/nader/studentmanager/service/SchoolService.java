package com.nader.studentmanager.service;

import com.nader.studentmanager.entity.School;
import com.nader.studentmanager.repository.SchoolRepository;
import com.nader.studentmanager.service.dto.AddSchoolDto;
import org.springframework.stereotype.Service;

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

}
