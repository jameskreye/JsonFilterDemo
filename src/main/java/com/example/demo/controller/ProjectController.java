package com.example.demo.controller;

import com.example.demo.data.ProjectRepository;
import com.example.demo.model.Project;
import com.example.demo.service.ProjectService;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping(value = "/listProjects")
    public ResponseEntity <MappingJacksonValue> getAllProjects(@RequestParam(value = "fields", required = false) String fields) {
        return projectService.getAllProjects(fields);
    }

    @PostMapping(value = "/project")
    public Project createProject(@RequestBody Project p) {
        return projectService.createProject(p);
    }

    @GetMapping(value = "/project/{id}")
    public ResponseEntity <MappingJacksonValue> getUser(@PathVariable("id") Long id,
                                                      @RequestParam(name = "fields", required = false) String fields) {
        MappingJacksonValue wrapper = new MappingJacksonValue(projectRepository.findById(id).get());

        if(fields != null && !fields.isEmpty()){
            wrapper.setFilters(new SimpleFilterProvider()
                    .addFilter("projectFilter",
                            SimpleBeanPropertyFilter.filterOutAllExcept(fields.split(","))));
        }else{
            wrapper.setFilters(new SimpleFilterProvider()
                    .addFilter("projectFilter", SimpleBeanPropertyFilter.serializeAllExcept())
                    .setFailOnUnknownId(false));
        }
        return ResponseEntity.ok(wrapper);
    }


}
