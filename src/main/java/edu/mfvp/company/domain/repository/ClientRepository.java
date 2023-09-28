package edu.mfvp.company.domain.repository;

import edu.mfvp.company.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
