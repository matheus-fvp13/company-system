package edu.mfvp.company.domain.repository;

import edu.mfvp.company.domain.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
