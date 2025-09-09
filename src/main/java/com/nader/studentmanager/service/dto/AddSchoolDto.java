package com.nader.studentmanager.service.dto;

import org.hibernate.validator.constraints.Length;

public class AddSchoolDto {
    @Length(min = 2, max = 50)
    private String name;
    @Length(min = 2, max = 100)
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
