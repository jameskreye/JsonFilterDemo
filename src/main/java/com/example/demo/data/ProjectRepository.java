package com.example.demo.data;

import com.example.demo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProjectRepository extends JpaRepository<Project, Long> {
}
