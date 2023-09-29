package edu.mfvp.company.service;

import edu.mfvp.company.dtos.ProjectDtoRecord;

import java.util.List;

public interface ProjectService {

    ProjectDtoRecord create(ProjectDtoRecord projectDtoRecord);
    List<ProjectDtoRecord> findAll();
    ProjectDtoRecord findById(Long id);
    ProjectDtoRecord update(Long id, ProjectDtoRecord projectDtoRecord);
    void delete(Long id);

}
