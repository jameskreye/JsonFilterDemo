package com.example.demo.service;

import com.example.demo.data.ProjectRepository;
import com.example.demo.model.Project;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;


    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }


    @Override
    public ResponseEntity<MappingJacksonValue> getAllProjects(String fields) {
        List<Project> projs = projectRepository.findAll();
        MappingJacksonValue mappingJacksonValue  = new MappingJacksonValue(projs);

        if(fields != null && !fields.isEmpty()) {
            mappingJacksonValue.setFilters(new SimpleFilterProvider().addFilter("projectFilter",
                    SimpleBeanPropertyFilter.filterOutAllExcept(fields.split(","))));
        }else{
            mappingJacksonValue.setFilters(new SimpleFilterProvider()
                    .addFilter("projectFilter", SimpleBeanPropertyFilter.serializeAllExcept())
                    .setFailOnUnknownId(false));
        }
        return ResponseEntity.ok(mappingJacksonValue);
    }
}
