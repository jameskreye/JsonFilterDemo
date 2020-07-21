package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@JsonFilter("projectFilter")
@Entity
public class Project implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String organizationOwner;
    private String createdBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date lastDateChanged;
    private String lastDeploymentId;

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizationOwner() {
        return organizationOwner;
    }

    public void setOrganizationOwner(String organizationOwner) {
        this.organizationOwner = organizationOwner;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastDateChanged() {
        return lastDateChanged;
    }

    public void setLastDateChanged(Date lastDateChanged) {
        this.lastDateChanged = lastDateChanged;
    }

    public String getLastDeploymentId() {
        return lastDeploymentId;
    }

    public void setLastDeploymentId(String lastDeploymentId) {
        this.lastDeploymentId = lastDeploymentId;
    }
}
