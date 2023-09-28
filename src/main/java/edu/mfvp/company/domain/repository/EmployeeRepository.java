package edu.mfvp.company.domain.repository;

import edu.mfvp.company.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
