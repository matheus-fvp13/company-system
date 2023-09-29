package edu.mfvp.company.domain.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "tb_employee")
public class Employee extends Person {

    @Column(name = "hire_date", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate hireDate;

    @Column(name = "termination_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate terminationDate;

    @ManyToMany(mappedBy = "team")
    private List<Project> projects;

    @ManyToOne
    @JoinColumn(name = "role_id_fk", nullable = false)
    private Role role;

}
