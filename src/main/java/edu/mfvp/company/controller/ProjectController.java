package edu.mfvp.company.controller;

import edu.mfvp.company.dtos.ProjectDtoRecord;
import edu.mfvp.company.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectDtoRecord> create(@RequestBody ProjectDtoRecord projectDtoRecord) {
        return new ResponseEntity<>(projectService.create(projectDtoRecord), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProjectDtoRecord>> findAll() {
        return ResponseEntity.ok().body(projectService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDtoRecord> findAll(@PathVariable Long id) {
        return ResponseEntity.ok().body(projectService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectDtoRecord> update(@PathVariable Long id, @RequestBody ProjectDtoRecord projectDtoRecord) {
        return ResponseEntity.ok().body(projectService.update(id, projectDtoRecord));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
