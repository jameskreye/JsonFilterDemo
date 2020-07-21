package com.example.demo.service;

import com.example.demo.model.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;


public interface ProjectService {
    Project createProject(Project project);
    ResponseEntity <MappingJacksonValue> getAllProjects(String fields);
}
