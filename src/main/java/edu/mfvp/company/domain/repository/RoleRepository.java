package edu.mfvp.company.domain.repository;

import edu.mfvp.company.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
    boolean existsByName(String name);

}
