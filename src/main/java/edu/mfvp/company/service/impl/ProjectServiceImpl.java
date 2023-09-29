package edu.mfvp.company.service.impl;

import edu.mfvp.company.domain.model.Client;
import edu.mfvp.company.domain.model.Project;
import edu.mfvp.company.domain.repository.ClientRepository;
import edu.mfvp.company.domain.repository.EmployeeRepository;
import edu.mfvp.company.domain.repository.ProjectRepository;
import edu.mfvp.company.dtos.ProjectDtoRecord;
import edu.mfvp.company.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;
    private ClientRepository clientRepository;
    private EmployeeRepository employeeRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, ClientRepository clientRepository, EmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ProjectDtoRecord create(ProjectDtoRecord projectDtoRecord) {
        return ProjectDtoRecord.toDto(projectRepository.save(updateProjectAux(projectDtoRecord)));
    }

    @Override
    public List<ProjectDtoRecord> findAll() {
        return projectRepository.findAll().stream().map(ProjectDtoRecord::toDto).collect(Collectors.toList());
    }

    @Override
    public ProjectDtoRecord findById(Long id) {
        if(!projectRepository.existsById(id)) throw new NoSuchElementException("There is no a project with id " + id);
        return ProjectDtoRecord.toDto(projectRepository.findById(id).get());
    }

    @Override
    public ProjectDtoRecord update(Long id, ProjectDtoRecord projectDtoRecord) {
        if(!projectRepository.existsById(id)) throw new NoSuchElementException("There is no a project with id " + id);
        Project oldProject = projectRepository.findById(id).get();
        Project updateProject = updateProjectAux(projectDtoRecord);
        updateProject.setId(oldProject.getId());
        return ProjectDtoRecord.toDto(projectRepository.save(updateProject));
    }

    @Override
    public void delete(Long id) {
        if(!projectRepository.existsById(id)) throw new NoSuchElementException("There is no a project with id " + id);
        projectRepository.deleteById(id);
    }

    private Project updateProjectAux(ProjectDtoRecord projectDtoRecord) {
        Long clientId = projectDtoRecord.clientId();
        Long leaderId = projectDtoRecord.leaderId();
        if(!clientRepository.existsById(clientId)) throw new NoSuchElementException("There is no a client with id " + clientId);
        if(!employeeRepository.existsById(leaderId)) throw new NoSuchElementException("There is no a leader with id " + leaderId);
        Project project = projectDtoRecord.toEntity();
        project.setClient(clientRepository.findById(clientId).get());
        project.setLeader(employeeRepository.findById(leaderId).get());
        project.setTeam(employeeRepository.findAllById(projectDtoRecord.teamIds()));
        return project;
    }

}
